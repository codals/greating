package com.codals.greating.diet.controller;

import static com.codals.greating.constant.SessionKey.DELIVERY_DATES;
import static com.codals.greating.constant.SessionKey.LOGIN_USER;
import static com.codals.greating.constant.SessionKey.ORDER_ID;

import com.codals.greating.diet.dto.DietDeliveryRequestDto;
import com.codals.greating.diet.dto.OrderRequestDto;
import com.codals.greating.diet.dto.OrderResponseDto;
import com.codals.greating.diet.service.DietService;
import com.codals.greating.user.entity.User;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/api/diets/mygreating")
@RequiredArgsConstructor
public class DietRestController {

    private final DietService dietService;

    public static final int DELIVERY_MAX_INACTIVE_INTERVAL = 300;

    @PostMapping("/orders")
    public ResponseEntity<Boolean> order(@SessionAttribute(LOGIN_USER) User user, @RequestBody OrderRequestDto orderRequestDto, HttpSession session) {
        OrderResponseDto response = dietService.order(user, orderRequestDto);
        session.setAttribute(ORDER_ID, response.getOrderId());
        return ResponseEntity.ok(true);
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
