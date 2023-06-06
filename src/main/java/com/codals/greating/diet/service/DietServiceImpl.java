package com.codals.greating.diet.service;

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
import com.codals.greating.diet.entity.OrderDiet;
import com.codals.greating.user.entity.User;
import com.codals.greating.util.DateUtil;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService {

    private final DailyDietDao dailyDietDao;
    private final OrderDao orderDao;
    private final OrderDietDao orderDietDao;

    @Override
    public List<PreviewResponseDto> getWeeklyDailyDiets() {
        List<DailyDiet> dailyDiets = dailyDietDao.selectAllByStartDate(DateUtil.dateToString(new Date()));
        return getPreviewResponseDto(dailyDiets);
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

}
