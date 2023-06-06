package com.codals.greating.email.dto;

import com.codals.greating.diet.dto.OrderRequestDto;
import com.codals.greating.user.entity.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class OrderDto {

    private String userName;
    private String userEmail;
    private List<OrderDietInfoDto> orders;
    private Integer week;
    private int mealCnt;
    private int deliveryCnt;
    private String totalPrice;

    public OrderDto(User user, OrderRequestDto orderRequestDto) {
        this.userName = user.getName();
        this.userEmail = user.getEmail();
        this.orders = orderRequestDto.getOrders().stream()
                .map(OrderDietInfoDto::new)
                .collect(Collectors.toList());
        this.week = orderRequestDto.getWeek();
        this.mealCnt = orderRequestDto.getMealCnt();
        this.deliveryCnt = 6;
        this.totalPrice = String.format("%,d", this.orders.stream()
                .mapToInt(order -> order.getCnt() * order.getPrice())
                .sum());
    }
}
