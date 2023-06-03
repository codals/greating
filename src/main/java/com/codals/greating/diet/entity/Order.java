package com.codals.greating.diet.entity;

import com.codals.greating.date.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order extends BaseEntity {

    private Integer id;
    private Integer subCategoryId;
    private Integer week;
    private Integer mealCnt;
    private Integer deliveryCnt;
    private Integer userId;
    private DeliveryStatus status;
}
