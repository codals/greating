package com.codals.greating.diet.service;

import com.codals.greating.diet.dto.OrderRequestDto;
import com.codals.greating.diet.dto.PlanResponseDto;
import com.codals.greating.diet.dto.PreviewResponseDto;
import com.codals.greating.user.entity.User;
import java.util.Date;
import java.util.List;

public interface DietService {

    List<PreviewResponseDto> getWeeklyDailyDiets();

    List<PlanResponseDto> getDailyDietsByDeliveryDates(List<Date> deliveryDates);

    void order(User user, OrderRequestDto orderRequestDto);
}
