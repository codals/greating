package com.codals.greating.diet.service;

import com.codals.greating.diet.dto.PreviewResponseDto;
import java.util.Date;
import java.util.List;

public interface DietService {

    List<PreviewResponseDto> getWeeklyDailyDiets();

    List<PreviewResponseDto> getDailyDietsByDeliveryDates(List<Date> deliveryDates);
}
