package com.codals.greating.diet.dao;

import com.codals.greating.diet.entity.DailyDiet;
import java.util.List;
import java.util.Optional;

public interface DailyDietDao {

    Optional<List<DailyDiet>> selectDailyDietsByStartDate(String startDateFormat);

    Optional<List<DailyDiet>> selectDailyDietsByStartDateOrEndDate(List<String> deliveryDates);
}
