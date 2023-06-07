package com.codals.greating.email.dto;

import com.codals.greating.diet.dto.OrderDietRequestDto;
import lombok.Data;

@Data
public class OrderDietInfoDto {

    private String deliveryDate;
    private String productName;
    private int cnt;
    private int price;

    public OrderDietInfoDto(OrderDietRequestDto orderDiet) {
        this.deliveryDate = orderDiet.getDeliveryDate();
        this.productName = orderDiet.getName();
        this.cnt = orderDiet.getCnt();
        this.price = Integer.parseInt(orderDiet.getPrice().replace(",", ""));
    }
}
