package com.codals.greating.diet.dto;

import com.codals.greating.user.entity.User;
import java.util.List;
import lombok.Data;

@Data
public class OrderRequestDto {

    private Integer orderId;
    private Integer userId;
    private List<OrderDietRequestDto> orders;
    private Integer subCategoryId;
    private Integer week;
    private Integer mealCnt;
    private Integer deliveryCnt;
    private int cnt;

    public void updateOrderInfo(User user) {
        this.userId = user.getId();
        this.subCategoryId = 1;
        this.week = 1;
        this.mealCnt = 6;
        this.deliveryCnt = 6;
        this.cnt = 1;
    }
}
