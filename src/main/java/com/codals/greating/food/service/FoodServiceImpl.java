package com.codals.greating.food.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.codals.greating.exception.BusinessException;
import com.codals.greating.exception.ErrorCode;
import com.codals.greating.food.dao.FoodDAO;
import com.codals.greating.food.dto.FoodDetailDto;
import com.codals.greating.food.dto.FoodSimpleDto;
import com.codals.greating.food.entity.Food;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
	Logger log = LogManager.getLogger("case3");

	private final FoodDAO foodDAO;
	
	@Override
	public List<FoodSimpleDto> loadGreatingFoodsByFoodType(int foodTypeId) {
		
		List<Food> foods = foodDAO.findGreatingFoodsByFoodTypeId(foodTypeId);
		if (foods == null) {
			throw new BusinessException(ErrorCode.FOOD_NOT_FOUND);
		}
				
		List<FoodSimpleDto> result = new ArrayList<>();
		for (Food food : foods) {
			result.add(new FoodSimpleDto(food.getId(), food.getName(), food.getImgUrl()));
		}
		return result;
	}

	@Override
	public List<FoodDetailDto> loadMarketFoodsByFoodType(int foodTypeId) {
		List<Food> foods = foodDAO.findMarketFoodsByFoodTypeId(foodTypeId);
		if (foods == null) {
			throw new BusinessException(ErrorCode.FOOD_NOT_FOUND);
		}
				
		List<FoodDetailDto> result = new ArrayList<>();
		for (Food food : foods) {
			result.add(new FoodDetailDto(food.getId(), food.getName(), food.getImgUrl(), food.getPrice(), food.getDescription()));
		}
		return result;

	}

	@Override
	public List<FoodSimpleDto> loadMarketFoodByRandom() {
		List<Food> foods =  foodDAO.selectMarketFoodByRandom();
		
		List<FoodSimpleDto> result = new ArrayList<>();
		for (Food food : foods) {
			result.add(new FoodSimpleDto(food.getId(), food.getName(), food.getImgUrl()));
		}
		return result;
	}
}	
