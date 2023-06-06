package com.codals.greating.diet.dao;

import com.codals.greating.diet.entity.DailyDiet;
import java.util.List;

public interface DailyDietDao {

    List<DailyDiet> selectAllByStartDate(String startDateFormat);

    List<DailyDiet> selectAllByStartDateOrEndDate(String deliveryDateFormat);
}
