package com.codals.greating.diet.dto;

import lombok.Data;

@Data
public class OrderResponseDto {

    private Integer orderId;

    public OrderResponseDto(Integer orderId) {
        this.orderId = orderId;
    }
}
