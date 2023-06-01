package com.codals.greating.diet.dto;

import java.util.List;
import lombok.Data;

@Data
public class OrderResultResponseDto {

    private OrderDetailResponseDto orderDetail;
    private List<OrderDietsByDateDto> orderDietsGroupByDeliveryDate;

    public OrderResultResponseDto(OrderDetailResponseDto orderDetail,
                                  List<OrderDietsByDateDto> orderDietsGroupByDeliveryDate) {
        this.orderDetail = orderDetail;
        this.orderDietsGroupByDeliveryDate = orderDietsGroupByDeliveryDate;
    }
}
