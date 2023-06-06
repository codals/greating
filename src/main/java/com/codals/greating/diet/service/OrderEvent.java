package com.codals.greating.diet.service;

import com.codals.greating.email.dto.OrderDto;
import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {

    private final OrderDto order;

    public OrderEvent(Object source, OrderDto order) {
        super(source);
        this.order = order;
    }

    public OrderDto getOrder() {
        return order;
    }
}
