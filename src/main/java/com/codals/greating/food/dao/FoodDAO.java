package com.codals.greating.food.dao;

import java.util.List;

import com.codals.greating.food.entity.Food;

public interface FoodDAO {

	List<Food> findGreatingFoodsByFoodTypeId(int foodTypeId);

	List<Food> findMarketFoodsByFoodTypeId(int foodTypeId);
	
}
