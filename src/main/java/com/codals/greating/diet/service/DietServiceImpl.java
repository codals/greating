package com.codals.greating.diet.service;

import com.codals.greating.constant.CacheKey;
import com.codals.greating.diet.dao.DailyDietDao;
import com.codals.greating.diet.dao.OrderDao;
import com.codals.greating.diet.dao.OrderDietDao;
import com.codals.greating.diet.dto.OrderDietsByDateDto;
import com.codals.greating.diet.dto.OrderDietDto;
import com.codals.greating.diet.dto.OrderDietRequestDto;
import com.codals.greating.diet.dto.OrderDetailResponseDto;
import com.codals.greating.diet.dto.OrderRequestDto;
import com.codals.greating.diet.dto.OrderResponseDto;
import com.codals.greating.diet.dto.OrderResultResponseDto;
import com.codals.greating.diet.dto.PlanResponseDto;
import com.codals.greating.diet.dto.PreviewDietResponseDto;
import com.codals.greating.diet.dto.PreviewResponseDto;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.Diet;
import com.codals.greating.diet.entity.OrderDiet;
import com.codals.greating.user.entity.User;
import com.codals.greating.util.DateUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService {

    private final OrderDao orderDao;
    private final OrderDietDao orderDietDao;
    private final DailyDietDao dailyDietDao;
    private final RedisTemplate<String, Object> redisTemplate;
    
    @Override
    public List<PreviewResponseDto> getWeeklyDailyDiets() {
    	List<DailyDiet> data = null;
    	String currentDate = DateUtil.dateToString(new Date());
    	String cacheKey = CacheKey.PREVIEW_DAILY_DIET_CACHE_KEY + currentDate;

    	List<PreviewResponseDto> response = null;

    	// 1. 캐시에 있는지 확인하고, 캐시에 있으면 가져오기
    	List<DailyDiet> cachedData = getCachedDailyDietsByDate(cacheKey);
    	if (cachedData != null) {
    		data = cachedData;
            log.info("redis에서 캐시 가져옴 - {}", cacheKey);
    		response = convertCacheToPreviews(data);
    	} else {
    		data = dailyDietDao.selectAllByStartDate(currentDate);
            log.info("redis에 캐시 데이터 없음 ");

            cacheDailyDiet(cacheKey, currentDate, data);
            log.info("새로 캐시 완료 - {}", cacheKey);
            
            return getPreviewResponseDto(data);
		}
    	
        return response;
    }
 
    private List<DailyDiet> getCachedDailyDietsByDate(String cacheKey) {
    	List<DailyDiet> cachedData = (List<DailyDiet>) redisTemplate.opsForValue().get(cacheKey);
    	return cachedData;
	}
    
	private void cacheDailyDiet(String cacheKey, String targetDate, List<DailyDiet> cachingData) {
	    redisTemplate.opsForValue().set(cacheKey, cachingData, 24 * 31, TimeUnit.HOURS);
	    log.info("PREVIEW cache를 1달간 Redis에 저장 : {}", cacheKey);
	}
    
    @Override
    public List<PlanResponseDto> getDailyDietsByDeliveryDates(List<Date> deliveryDates) {
        return deliveryDates.stream()
            .map(deliveryDate -> {
                String deliveryDateFormat = DateUtil.dateToString(deliveryDate);
                List<DailyDiet> dailyDiets = dailyDietDao.selectAllByStartDateOrEndDate(deliveryDateFormat);
                List<PreviewDietResponseDto> dietsResponse = dailyDiets.stream()
                    .map(dailyDiet -> new PreviewDietResponseDto(dailyDiet.getDiet()))
                    .collect(Collectors.toList());
                return new PlanResponseDto(deliveryDateFormat, dietsResponse);
            })
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderResponseDto order(User user, OrderRequestDto orderRequestDto) {
        orderRequestDto.updateOrderInfo(user);
        orderDao.saveOrder(orderRequestDto);
        for (OrderDietRequestDto orderDiet : orderRequestDto.getOrders()) {
            if (orderDiet.getCnt() > 0) {
                orderDiet.updateOrderId(orderRequestDto.getOrderId());
                orderDietDao.insertOrderDiet(orderDiet);
            }
        }
        return new OrderResponseDto(orderRequestDto.getOrderId());
    }

    @Override
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
    
    private List<PreviewResponseDto> convertCacheToPreviews(List<?> cacheDiets) {    	
    	Map<LocalDate, List<PreviewDietResponseDto>> dateDietMap = new TreeMap<>();
    	
    	for (Object cacheUnit : cacheDiets) {
    		DailyDiet dailyDiet = new DailyDiet((LinkedHashMap<String, Object>) cacheUnit);
    		List<PreviewDietResponseDto> list = dateDietMap.computeIfAbsent(dailyDiet.getStartDate(), k -> new ArrayList<>());
            list.add(new PreviewDietResponseDto(dailyDiet.getDiet()));
    	}
    	
    	List<PreviewResponseDto> result = new ArrayList<PreviewResponseDto>();
    	for (LocalDate key : dateDietMap.keySet()) {
    		result.add(new PreviewResponseDto(key, dateDietMap.get(key)));
    	}    	
    	return result;  
    }

}
