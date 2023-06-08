package com.codals.greating.admin.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.codals.greating.admin.dto.AdminDailyDietResponseDto;
import com.codals.greating.admin.dto.AdminDto;
import com.codals.greating.admin.dto.DiyToDietRequestDto;
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
	public boolean approveCheck(int postId) {
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

	// 출시 예정 고려 취소 
	@Override
	public boolean approveCancel(int postId) {
		int updatedRows = sqlSession.update("admin.approveCancel", postId);
		return updatedRows > 0;
	}

	@Override
	public boolean updatePostStatusToDiet(int postId) {
		int updatedRows = sqlSession.update("admin.updatePostStatusToDiet", postId);
		return updatedRows > 0;
	}

//	@Override
//	public boolean approveDiyCancel(long postId) {
//		int updatedRows = sqlSession.delete("admin.approveDiyCancel", postId);
//		return updatedRows > 0;
//	}

	@Override
	public boolean approveDiyRegister(int postId) {
		int insertRows = sqlSession.insert("admin.registerDiy", postId);
		return insertRows > 0;
	}

	

	@Override
	public List<AdminDto> allList() {
		return sqlSession.selectList("admin.allList");
	}

	@Override
	public boolean deletePost(int postId) {
		int insertRows = sqlSession.delete("admin.deletePost", postId);
		return insertRows > 0;
	}

	@Override
	public boolean insertPostToDiet(DiyToDietRequestDto requestDto) {
		int result = sqlSession.insert("admin.insertPostToDiet", requestDto);
		return result>0;
	}

	@Override
	public boolean deleteDietByPost(int postId) {
		int result = sqlSession.delete("admin.deleteDietByPost", postId);
		return result > 0;
	}

	@Override
	public boolean updatePostStatusToReady(int postId) {
		int updatedRows = sqlSession.update("admin.updatePostStatusToReady", postId);
		return updatedRows > 0;		
	}




}
