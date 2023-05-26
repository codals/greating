package com.codals.greating.diet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diets/mygreating")
public class DietController {

    @GetMapping
    public String loadOrderMainPage() {
        /**
         * order-main.jsp 예정
         */
        return "order/order-main";
    }

    @GetMapping("/preview")
    public String loadDietPreviewPage() {
        return "order/order-menu-info";
    }

    @GetMapping("/orders/schedule")
    public String loadOrderSchedulePage() {
        return "order/order-step1";
    }

    @GetMapping("/orders/delivery")
    public String loadOrderDeliveryPage() {
        return "order/order-step2";
    }

    @GetMapping("/orders/choice")
    public String loadOrderChoicePage() {
        return "order/meal-choice";
    }

    @GetMapping("/orders/result")
    public String loadOrderResultPage() {
        return "order/order-result";
    }

    @PostMapping("/orders")
    public boolean order() {
        /**
         * 식단 주문하기 (Ajax)
         */
        return true;
    }

    @GetMapping("/cart")
    public String loadCartPage() {
        /**
         * cart.jsp 예정 (cart 디렉토리 재설정 필요)
         */
        return "order/cart";
    }

    @PostMapping("/cart")
    public String addToCart() {
        /**
         * 장바구니 담기
         */
        return "redirect:/diets/mygreating/cart";
    }
}
