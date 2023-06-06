package com.codals.greating.diet;

import com.codals.greating.email.dto.OrderDto;
import org.springframework.context.ApplicationEvent;

public class OrderConfirmationEvent extends ApplicationEvent {

    private final OrderDto order;

    public OrderConfirmationEvent(Object source, OrderDto order) {
        super(source);
        this.order = order;
    }

    public OrderDto getOrder() {
        return order;
    }
}
