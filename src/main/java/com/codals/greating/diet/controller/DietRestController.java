package com.codals.greating.diet.controller;

import static com.codals.greating.constant.SessionKey.DELIVERY_DATES;

import com.codals.greating.diet.dto.DietDeliveryRequestDto;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diets/mygreating")
public class DietRestController {

    public static final int MAX_INACTIVE_INTERVAL = 300;
    public static final int DELIVERY_MAX_INACTIVE_INTERVAL = 300;

    @PostMapping("/orders")
    public boolean order() {
        /**
         * 식단 주문하기 (Ajax)
         */
        return true;
    }

    @PostMapping("/orders/delivery")
    public ResponseEntity<Boolean> saveDelivery(@RequestBody DietDeliveryRequestDto dietDeliveryRequestDto, HttpSession session) {
        session.setAttribute(DELIVERY_DATES, dietDeliveryRequestDto.getDates());
        session.setMaxInactiveInterval(DELIVERY_MAX_INACTIVE_INTERVAL);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/cart")
    public String addToCart() {
        /**
         * 장바구니 담기
         */
        return "redirect:/diets/mygreating/cart";
    }
}
