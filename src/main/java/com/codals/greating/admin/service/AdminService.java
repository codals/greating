package com.codals.greating.admin.service;

import java.util.List;

import com.codals.greating.admin.dto.AdminDailyDietResponseDto;
import com.codals.greating.admin.dto.AdminDietRegisterRequestDto;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.Diet;
import com.codals.greating.admin.dto.AdminDto;
import com.codals.greating.admin.dto.DiyToDietRequestDto;

public interface AdminService {

	List<Diet> getDietsByMainCategory(MainCategoryCode category);

	boolean registerDailyDiets(AdminDietRegisterRequestDto requestDto);
	
	List<AdminDto> topList();

	boolean approveCheck(int postId);

	List<AdminDto> commingSoonList();

	List<AdminDailyDietResponseDto> getDailyDietsByDate(String date);

	boolean approveCancel(int postId);


//	boolean approveDiyCancel(long postId);

	boolean approveDiyRegister(int postId);


	List<AdminDto> allList();

	boolean cancelDiet(int postId);

	boolean diyToDiet(DiyToDietRequestDto requestDto);

	boolean deletePost(int postId);

}
