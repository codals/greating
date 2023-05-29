package com.codals.greating.diet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diets/mygreating")
public class DietRestController {

    @PostMapping("/orders")
    public boolean order() {
        /**
         * 식단 주문하기 (Ajax)
         */
        return true;
    }

    @PostMapping("/cart")
    public String addToCart() {
        /**
         * 장바구니 담기
         */
        return "redirect:/diets/mygreating/cart";
    }
}
