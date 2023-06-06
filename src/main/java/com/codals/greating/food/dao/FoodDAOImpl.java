package com.codals.greating.food.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.codals.greating.food.dto.FoodSimpleDto;
import com.codals.greating.food.entity.Food;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FoodDAOImpl implements FoodDAO {
	private final SqlSession session;

	@Override
	public List<Food> findGreatingFoodsByFoodTypeId(int foodTypeId) {
		String statement = "food.findAllGreatingFoodByFoodTypeId";
		List<Food> result = session.selectList(statement, foodTypeId);
		return result;
	}

	@Override
	public List<Food> findMarketFoodsByFoodTypeId(int foodTypeId) {
		String statement = "food.findAllMarketFoodByFoodTypeId";
		List<Food> result = session.selectList(statement, foodTypeId);
		return result;
	}

	@Override
	public List<Food> selectMarketFoodByRandom() {
		String statement = "food.selectMarketFoodByRandom";
		return session.selectList(statement);
	}

}
