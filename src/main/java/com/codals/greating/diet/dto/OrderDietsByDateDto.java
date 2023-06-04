package com.codals.greating.diet.dto;

import com.codals.greating.util.DateUtil;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class OrderDietsByDateDto {

    private String deliveryDate;
    private String deliveryDay;
    private List<OrderDietDto> orderDiets;

    public OrderDietsByDateDto(Date deliveryDate, List<OrderDietDto> orderDiets) {
        this.deliveryDate = DateUtil.dateToString(deliveryDate);
        this.deliveryDay = DateUtil.dateToDay(deliveryDate);
        this.orderDiets = orderDiets;
    }
}
