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
        /**
         * order-step2.jsp 예정
         */
        return "order/order-step2";
    }

    @GetMapping("/orders/choice")
    public String loadOrderChoicePage() {
        /**
         * order-choice.jsp 예정
         */
        return "order/order-choice";
    }

    @PostMapping("/orders/confirmation")
    public String loadOrderResultPage() {
        /**
         * order-result.jsp 예정 (식단 주문 로직)
         */
        return "order/order-result";
    }
}
