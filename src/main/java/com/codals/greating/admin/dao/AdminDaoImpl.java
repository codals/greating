package com.codals.greating.admin.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.codals.greating.admin.dto.AdminDto;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.Diet;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class AdminDaoImpl implements AdminDao {
	private final SqlSession sqlSession;

	@Override
	public List<Diet> selectDietsByMainCategory(MainCategoryCode category) {

		String statement = "diet.selectDietsByMainCategory";
		int searchCategory = category.getId();
		return sqlSession.selectList(statement, searchCategory);
	}

	@Override
	public List<AdminDto> topList() {
		return sqlSession.selectList("admin.topList");

	}

	@Override
	public int insertDailyDiets(List<DailyDiet> diets) {
		String statement = "diet.insertDailyDiets";
		return sqlSession.update(statement, diets);
	}

	@Override
	public boolean approveCheck(long postId) {
		int updatedRows = sqlSession.update("admin.approveCheck", postId);
		return updatedRows > 0;

	}

}
