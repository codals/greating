package com.codals.greating.diet;

import com.codals.greating.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConfirmationHandler implements ApplicationListener<OrderConfirmationEvent> {

    private final EmailService emailService;

    @Override
    public void onApplicationEvent(OrderConfirmationEvent event) {
        emailService.sendOrderEmail(event.getOrder());
    }
}
