package com.codals.greating.food.dao;

import java.util.List;

import com.codals.greating.food.entity.Food;

public interface FoodDAO {

	List<Food> findByFoodTypeId(int foodTypeId);

}
