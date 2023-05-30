package com.codals.greating.food.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.codals.greating.diy.entity.Food;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FoodDAOImpl implements FoodDAO {
	private final SqlSession session;

	@Override
	public List<Food> findByFoodTypeId(int foodTypeId) {
		String statement = "food.findAllByFoodTypeId";
		List<Food> result = session.selectList(statement, foodTypeId);
		return result;
	}

}
