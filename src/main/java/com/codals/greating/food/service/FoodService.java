package com.codals.greating.food.service;

import java.util.List;

import com.codals.greating.diy.dto.FoodSimpleDto;

public interface FoodService {

	List<FoodSimpleDto> loadFoodsByFoodType(int foodTypeId);
}
