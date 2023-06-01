package com.codals.greating.food.service;

import java.util.List;

import com.codals.greating.food.dto.FoodDetailDto;
import com.codals.greating.food.dto.FoodSimpleDto;

public interface FoodService {

	List<FoodSimpleDto> loadGreatingFoodsByFoodType(int foodTypeId);

	List<FoodDetailDto> loadMarketFoodsByFoodType(int foodTypeId);
}
