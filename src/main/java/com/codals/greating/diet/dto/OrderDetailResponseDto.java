package com.codals.greating.diet.dto;

import com.codals.greating.diet.entity.Order;
import com.codals.greating.diet.entity.OrderDiet;
import java.util.List;
import lombok.Data;

@Data
public class OrderDetailResponseDto {

    private String subCategoryName;
    private Integer week;
    private Integer mealCnt;
    private Integer deliveryCnt;
    private String totalPriceFormat;

    public OrderDetailResponseDto(Order order, List<OrderDiet> orderDiets) {
        this.subCategoryName = "저당식단"; // enum 예정
        this.week = order.getWeek();
        this.mealCnt = order.getMealCnt();
        this.deliveryCnt = order.getDeliveryCnt();
        this.totalPriceFormat = String.format("%,d", orderDiets.stream()
            .mapToInt(orderDiet -> orderDiet.getDiet().getPrice() * orderDiet.getCnt())
            .sum());
    }
}
