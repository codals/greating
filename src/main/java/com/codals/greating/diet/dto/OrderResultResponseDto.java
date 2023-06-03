package com.codals.greating.diet.dto;

import java.util.List;
import lombok.Data;

@Data
public class OrderResultResponseDto {

    private OrderDetailResponseDto orderDetail;
    private List<OrderDietsByDateDto> orderDietsByDates;

    public OrderResultResponseDto(OrderDetailResponseDto orderDetail,
                                  List<OrderDietsByDateDto> orderDietsByDates) {
        this.orderDetail = orderDetail;
        this.orderDietsByDates = orderDietsByDates;
    }
}
