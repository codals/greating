package com.codals.greating.diet.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDiet {

    private Integer id;
    private Integer dietId;
    private Integer orderId;
    private Date deliveryDate;
    private int cnt;
    private Diet diet;
}
