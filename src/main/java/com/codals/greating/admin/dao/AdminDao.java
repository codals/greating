package com.codals.greating.admin.dao;


import java.util.Date;
import java.util.List;

import com.codals.greating.admin.dto.AdminDailyDietResponseDto;
import com.codals.greating.admin.dto.AdminDto;
import com.codals.greating.admin.dto.DiyToDietRequestDto;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.Diet;

public interface AdminDao {

	List<Diet> selectDietsByMainCategory(MainCategoryCode category);

	int insertDailyDiets(List<DailyDiet> diets);

	List<AdminDto> topList();

	boolean approveCheck(int postId);

	List<AdminDto> commingSoonList();

	List<AdminDailyDietResponseDto> selectDailyDietsByDate(String date);

	public boolean approveCancel(int postId);

	boolean updatePostStatusToDiet(int postId) throws Exception;

	//boolean approveDiyCancel(long postId);

	boolean approveDiyRegister(int postId);

	List<AdminDto> allList();

	boolean deletePost(int postId);

	boolean insertPostToDiet(DiyToDietRequestDto requestDto) throws Exception;

	boolean deleteDietByPost(int postId);

	boolean updatePostStatusToReady(int postId);

}
