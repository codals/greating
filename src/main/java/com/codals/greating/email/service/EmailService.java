package com.codals.greating.email.service;

import com.codals.greating.email.dto.OrderDto;

public interface EmailService {

    void sendOrderEmail(OrderDto order);
}
