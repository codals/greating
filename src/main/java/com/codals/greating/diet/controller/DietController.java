package com.codals.greating.diet.controller;

import com.codals.greating.diet.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diets/mygreating")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @GetMapping
    public String loadOrderMainPage() {
        /**
         * order-main.jsp 예정
         */
        return "order/order-main";
    }

    @GetMapping("/preview")
    public String loadDietPreviewPage(Model model) {
        model.addAttribute("weeklyDailyDiets", dietService.getWeeklyDailyDiets());
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

    @GetMapping("/cart")
    public String loadCartPage() {
        /**
         * cart.jsp 예정 (cart 디렉토리 재설정 필요)
         */
        return "order/cart";
    }
}
