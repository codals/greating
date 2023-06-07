package com.codals.greating.diet.service;

import com.codals.greating.diet.OrderConfirmationEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.codals.greating.aop.ExecutionTime;
import com.codals.greating.constant.CacheKey;
import com.codals.greating.diet.dao.DailyDietDao;
import com.codals.greating.diet.dao.OrderDao;
import com.codals.greating.diet.dao.OrderDietDao;
import com.codals.greating.diet.dto.OrderDetailResponseDto;
import com.codals.greating.diet.dto.OrderDietDto;
import com.codals.greating.diet.dto.OrderDietRequestDto;
import com.codals.greating.diet.dto.OrderDietsByDateDto;
import com.codals.greating.diet.dto.OrderRequestDto;
import com.codals.greating.diet.dto.OrderResponseDto;
import com.codals.greating.diet.dto.OrderResultResponseDto;
import com.codals.greating.diet.dto.PlanResponseDto;
import com.codals.greating.diet.dto.PreviewDietResponseDto;
import com.codals.greating.diet.dto.PreviewResponseDto;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.OrderDiet;
import com.codals.greating.email.dto.OrderDto;
import com.codals.greating.user.entity.User;
import com.codals.greating.util.DateUtil;

import org.springframework.context.ApplicationEventPublisher;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DietServiceImpl implements DietService {

    private final OrderDao orderDao;
    private final OrderDietDao orderDietDao;
    private final ApplicationEventPublisher eventPublisher;
    private final DailyDietDao dailyDietDao;
    private final RedisTemplate<String, Object> redisTemplate;

    // 생성자에 @Qualifier 적용
    public DietServiceImpl(OrderDao orderDao, OrderDietDao orderDietDao, DailyDietDao dailyDietDao, ApplicationEventPublisher eventPublisher, @Qualifier("redisJacksonTemplate") RedisTemplate<String, Object> redisTemplate) {
        this.orderDao = orderDao;
        this.orderDietDao = orderDietDao;
        this.eventPublisher = eventPublisher;
        this.dailyDietDao = dailyDietDao;
        this.redisTemplate = redisTemplate;
    }

    @Override
    @ExecutionTime
    public List<PreviewResponseDto> getWeeklyDailyDiets() {
    	List<DailyDiet> data = null;
    	String currentDate = DateUtil.dateToString(new Date());
    	String cacheKey = CacheKey.TWO_WEEK_PREVIEW_CACHE_KEY + currentDate;

    	log.info("today=" + currentDate);
    	log.info("result=" + dailyDietDao.selectAllByStartDate(currentDate));
    	
    	List<PreviewResponseDto> response = null;

    	List<DailyDiet> cachedData = getCachedTwoWeekDailyDiets(cacheKey);
    	if (cachedData != null) {    	// 1. 캐시에 있는지 확인하고, 캐시에 있으면 가져오기
    		response = convertCacheToPreviews(cachedData);
    	    log.info("[REDIS] TWO_WEEK_PREVIEW - Cache Hit - {}", cacheKey);
    	} else {						// 2. 캐시에 없으면  DB에서 가져오기, 캐싱해두기
            log.info("[REDIS] TWO_WEEK_PREVIEW - Cache Miss - {}", cacheKey);
            data = dailyDietDao.selectAllByStartDate(currentDate);
            log.info("data= " + data);

            cacheTwoWeekDailyDiets(cacheKey, data);
            response = getPreviewResponseDto(data);
            log.info("response= " + data);
		}

        return response;
    }

    // 2주치 Daily Diet 캐시 가져오기
    @ExecutionTime
    private List<DailyDiet> getCachedTwoWeekDailyDiets(String cacheKey) {
    	@SuppressWarnings("unchecked")
		List<DailyDiet> cachedData = (List<DailyDiet>) redisTemplate.opsForValue().get(cacheKey);
    	return cachedData;
	}

    // 2주치 Daily Diet 캐싱하기
	private void cacheTwoWeekDailyDiets(String cacheKey, List<DailyDiet> cachingData) {
	    redisTemplate.opsForValue().set(cacheKey, cachingData, 1, TimeUnit.DAYS);
	    log.info("[REDIS] TWO_WEEK_PREVIEW - Cache 저장 - {}", cacheKey);
	}

    @Override
    @ExecutionTime
    public List<PlanResponseDto> getDailyDietsByDeliveryDates(List<Date> deliveryDates) {
        return deliveryDates.stream()
            .map(deliveryDate -> {
                String deliveryDateFormat = DateUtil.dateToString(deliveryDate);

        		List<PreviewDietResponseDto> dietsResponse = null;

                // 1. 캐시에 있는지 확인하고, 캐시에 있으면 가져오기
            	String cacheKey = CacheKey.DAILY_PREVIEW_CACHE_KEY + deliveryDateFormat;
            	List<?> cachedData = getCachedDailyDiet(cacheKey);
            	if (cachedData != null) {
            		@SuppressWarnings("unchecked")
					List<DailyDiet> dailyDiets = cachedData.stream()
            											   .map(cache -> new DailyDiet((LinkedHashMap<String, Object>) cache))
            											   .collect(Collectors.toList());
            		dietsResponse = dailyDiets.stream()
							                  .map(dailyDiet -> new PreviewDietResponseDto(((DailyDiet) dailyDiet).getDiet()))
							                  .collect(Collectors.toList());
                    log.info("[REDIS] DAILY_PREVIEW - Cache Hit - {}", cacheKey);
            	} else {
                    log.info("[REDIS] DAILY_PREVIEW - Cache Miss - {}", cacheKey);
                    List<DailyDiet> dailyDiets = dailyDietDao.selectAllByStartDateOrEndDate(deliveryDateFormat);
            		dietsResponse = dailyDiets.stream()
							                   .map(dailyDiet -> new PreviewDietResponseDto(dailyDiet.getDiet()))
							                   .collect(Collectors.toList());

            		cacheDailyDiet(cacheKey, dailyDiets);
            	}

                return new PlanResponseDto(deliveryDateFormat, dietsResponse);
            })
           .collect(Collectors.toList());
    }

    @ExecutionTime
    private List<DailyDiet> getCachedDailyDiet(String cacheKey) {
    	@SuppressWarnings("unchecked")
		List<DailyDiet> cachedData = (List<DailyDiet>) redisTemplate.opsForValue().get(cacheKey);
    	return cachedData;
	}

	private void cacheDailyDiet(String cacheKey, List<DailyDiet> cachingData) {
	    redisTemplate.opsForValue().set(cacheKey, cachingData, 1, TimeUnit.DAYS);
	    log.info("[REDIS] DAILY_PREVIEW - Cache 저장 - {}", cacheKey);
	}
	
    @Override
    @ExecutionTime
    public OrderResponseDto order(User user, OrderRequestDto orderRequestDto) {
        orderRequestDto.updateOrderInfo(user);
        orderDao.saveOrder(orderRequestDto);
        for (OrderDietRequestDto orderDiet : orderRequestDto.getOrders()) {
            if (orderDiet.getCnt() > 0) {
                orderDiet.updateOrderId(orderRequestDto.getOrderId());
                orderDietDao.insertOrderDiet(orderDiet);
            }
        }
        OrderConfirmationEvent orderEvent = new OrderConfirmationEvent(this, new OrderDto(user, orderRequestDto));
        eventPublisher.publishEvent(orderEvent);
        return new OrderResponseDto(orderRequestDto.getOrderId());
    }

    @Override
    @ExecutionTime
    public OrderResultResponseDto getOrderDetail(Integer orderId) {
        List<OrderDiet> orderDiets = orderDietDao.selectAllByOrderId(orderId);
        OrderDetailResponseDto orderDetailResponseDto = new OrderDetailResponseDto(orderDao.selectById(orderId),
            orderDiets);

        Map<Date, List<OrderDiet>> orderDietsMap = orderDiets.stream()
            .collect(Collectors.groupingBy(OrderDiet::getDeliveryDate));
        List<OrderDietsByDateDto> orderDietsResponseDto = orderDietsMap.entrySet().stream()
            .map(entry -> new OrderDietsByDateDto(entry.getKey(), entry.getValue().stream()
                .map(OrderDietDto::new)
                .collect(Collectors.toList()))
            )
            .sorted(Comparator.comparing(OrderDietsByDateDto::getDeliveryDate))
            .collect(Collectors.toList());
        return new OrderResultResponseDto(orderDetailResponseDto, orderDietsResponseDto);
    }

    @ExecutionTime
    private List<PreviewResponseDto> getPreviewResponseDto(List<DailyDiet> dailyDiets) {
        Map<LocalDate, List<DailyDiet>> dailyDietsByStartDate = dailyDiets.stream()
            .collect(Collectors.groupingBy(DailyDiet::getStartDate));

        return dailyDietsByStartDate.entrySet().stream()
            .map(entry -> new PreviewResponseDto(entry.getKey(), entry.getValue().stream()
                .map(dailyDiet -> new PreviewDietResponseDto(dailyDiet.getDiet()))
                .collect(Collectors.toList())))
            .sorted(Comparator.comparing(PreviewResponseDto::getStartDate))
            .collect(Collectors.toList());
    }

    @ExecutionTime
    private List<PreviewResponseDto> convertCacheToPreviews(List<?> cacheDiets) {
    	Map<LocalDate, List<PreviewDietResponseDto>> dateDietMap = new TreeMap<>();

    	for (Object cacheUnit : cacheDiets) {
    		@SuppressWarnings("unchecked")
			DailyDiet dailyDiet = new DailyDiet((LinkedHashMap<String, Object>) cacheUnit);
    		List<PreviewDietResponseDto> list = dateDietMap.computeIfAbsent(dailyDiet.getStartDate(), k -> new ArrayList<>());
            list.add(new PreviewDietResponseDto(dailyDiet.getDiet()));
    	}

    	List<PreviewResponseDto> result = new ArrayList<>();
    	for (LocalDate key : dateDietMap.keySet()) {
    		result.add(new PreviewResponseDto(key, dateDietMap.get(key)));
    	}
    	return result;
    }

}
