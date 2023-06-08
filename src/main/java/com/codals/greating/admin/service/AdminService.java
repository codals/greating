package com.codals.greating.admin.service;

import java.util.List;

import com.codals.greating.admin.dto.AdminDailyDietResponseDto;
import com.codals.greating.admin.dto.AdminDietRegisterRequestDto;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.Diet;
import com.codals.greating.admin.dto.AdminDto;

public interface AdminService {

	List<Diet> getDietsByMainCategory(MainCategoryCode category);

	boolean registerDailyDiets(AdminDietRegisterRequestDto requestDto);
	
	List<AdminDto> topList();

	boolean approveCheck(long postId);

	List<AdminDto> commingSoonList();

	List<AdminDailyDietResponseDto> getDailyDietsByDate(String date);

	boolean approveCancel(long postId);

	boolean approveDiy(long postId);

	boolean approveDiyCancel(long postId);

	boolean approveDiyRegister(int postId);

	boolean submitPrice(int postId, int price);

	List<AdminDto> allList();

	boolean deleteDiy(int postId);

}
