package com.codals.greating.admin.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.codals.greating.admin.dto.AdminDailyDietResponseDto;
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
		String statement = "admin.insertDailyDiets";
		return sqlSession.update(statement, diets);
	}

	@Override
	public boolean approveCheck(long postId) {
		int updatedRows = sqlSession.update("admin.approveCheck", postId);
		return updatedRows > 0;

	}

  @Override
  public List<AdminDto> commingSoonList() {
    return sqlSession.selectList("admin.commingSoonList");
  }

	@Override
	public List<AdminDailyDietResponseDto> selectDailyDietsByDate(String date) {
		String statement = "admin.selectDailyDietsByDate";
		return sqlSession.selectList(statement, date);
	}

	@Override
	public boolean approveCancel(long postId) {
		int updatedRows = sqlSession.update("admin.approveCancel", postId);
		return updatedRows > 0;
	}

	@Override
	public boolean approveDiy(long postId) {
		System.out.println("내가 확인하려는 것입니다.");
		int updatedRows = sqlSession.update("admin.approveCheck", postId);
		return updatedRows > 0;
	}

	@Override
	public boolean approveDiyCancel(long postId) {
		int updatedRows = sqlSession.delete("admin.approveDiyCancel", postId);
		return updatedRows > 0;
	}

	@Override
	public boolean approveDiyRegister(int postId) {
		int insertRows = sqlSession.insert("admin.registerDiy", postId);
		return insertRows > 0;
	}

	
	@Override
	public boolean submitPrice(int postId, int price) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("postId", postId);
	    params.put("price", price);

	    int insertRows = sqlSession.update("admin.submitPrice", params);
	    return insertRows > 0;
	}

	@Override
	public List<AdminDto> allList() {
		return sqlSession.selectList("admin.allList");
	}

	@Override
	public boolean deleteDiy(int postId) {
		// TODO Auto-generated method stub
		int insertRows = sqlSession.update("admin.deleteDiy", postId);
		return insertRows > 0;
	}



}
