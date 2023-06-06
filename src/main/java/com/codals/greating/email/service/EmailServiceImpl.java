package com.codals.greating.email.service;

import com.codals.greating.external.sender.GmailEmailSender;
import com.codals.greating.email.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final GmailEmailSender gmailEmailSender;
    private static final String SUBJECT_ORDER_COMPLETED = "주문 확인 및 배송 안내";

    @Async
    @Override
    @EventListener
    public void sendOrderEmail(OrderDto order) {
        Context context = new Context();
        context.setVariable("name", order.getUserName());
        context.setVariable("orders", order.getOrders());
        context.setVariable("week", order.getWeek());
        context.setVariable("mealCnt", order.getMealCnt());
        context.setVariable("deliveryCnt", order.getDeliveryCnt());
        context.setVariable("totalPrice", order.getTotalPrice());
        gmailEmailSender.sendEmail(order.getUserEmail(), SUBJECT_ORDER_COMPLETED, "email/order-confirmation", context);
    }
}
