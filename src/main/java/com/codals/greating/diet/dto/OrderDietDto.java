package com.codals.greating.diet.dto;

import com.codals.greating.diet.entity.OrderDiet;
import lombok.Data;

@Data
public class OrderDietDto {

    private String name;
    private int cnt;

    public OrderDietDto(OrderDiet orderDiet) {
        this.name = orderDiet.getDiet().getName();
        this.cnt = orderDiet.getCnt();
    }
}
