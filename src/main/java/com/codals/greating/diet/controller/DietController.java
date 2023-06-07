package com.codals.greating.diet.controller;

import static com.codals.greating.constant.SessionKey.DELIVERY_DATES;
import static com.codals.greating.constant.SessionKey.ORDER_ID;

import com.codals.greating.diet.dto.OrderResultResponseDto;
import com.codals.greating.diet.service.DietService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/diets/mygreating")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @GetMapping
    public String loadOrderMainPage() {
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
    public String loadOrderChoicePage(@SessionAttribute(name = DELIVERY_DATES, required = false) List<Date> deliveryDates, Model model) {
        if (deliveryDates == null) {
            return "redirect:/diets/mygreating/orders/schedule";
        }
        model.addAttribute("dailyDiets", dietService.getDailyDietsByDeliveryDates(deliveryDates));
        return "order/meal-choice";
    }

    @GetMapping("/orders/result")
    public String loadOrderResultPage(@SessionAttribute(name = ORDER_ID, required = false) Integer orderId, Model model, HttpSession session) {
        if (orderId == null) {
            return "redirect:/diets/mygreating/orders/schedule";
        }
        OrderResultResponseDto orderDetail = dietService.getOrderDetail(orderId);
        model.addAttribute("orderDetail", orderDetail.getOrderDetail());
        model.addAttribute("orderDietsGroupByDeliveryDate", orderDetail.getOrderDietsByDates());
        session.removeAttribute(DELIVERY_DATES);
        session.removeAttribute(ORDER_ID);
        return "order/order-result";
    }
}
