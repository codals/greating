package com.codals.greating.admin.service;

import java.util.List;

import com.codals.greating.admin.dto.AdminDietRegisterRequestDto;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.Diet;

public interface AdminService {

	List<Diet> getDietsByMainCategory(MainCategoryCode category);

	boolean registerDailyDiets(AdminDietRegisterRequestDto requestDto);

}
