package com.codals.greating.diet.service;

import com.codals.greating.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderHandler implements ApplicationListener<OrderEvent> {

    private final EmailService emailService;

    @Override
    public void onApplicationEvent(OrderEvent event) {
        emailService.sendOrderEmail(event.getOrder());
    }
}
