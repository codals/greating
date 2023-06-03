package com.codals.greating.diet.dto;

import lombok.Data;

@Data
public class OrderDietRequestDto {

    private Integer orderId;
    private Integer dietId;
    private int cnt;
    private String deliveryDate;

    public void updateOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
