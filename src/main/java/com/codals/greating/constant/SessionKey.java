package com.codals.greating.constant;

import lombok.Getter;

@Getter
public class SessionKey {

    private SessionKey() {
    }

    public static final String LOGIN_USER = "loginUser";
    public static final String DELIVERY_DATES = "deliveryDates";
    public static final String ORDER_ID = "orderId";
    public static final String COMPLETED_ORDER_CNT = "completedOrderCnt";
}
