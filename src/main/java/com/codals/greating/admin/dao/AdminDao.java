package com.codals.greating.admin.dao;

import java.util.Date;
import java.util.List;

import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.Diet;

public interface AdminDao {

	List<Diet> selectDietsByMainCategory(MainCategoryCode category);


	int insertDailyDiets(List<DailyDiet> diets);

}
