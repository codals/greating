package com.codals.greating.admin.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codals.greating.admin.dao.AdminDao;
import com.codals.greating.admin.dto.AdminDietRegisterRequestDto;
import com.codals.greating.admin.dto.AdminDto;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.Diet;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

	private final AdminDao adminDao;

	@Override
	public List<Diet> getDietsByMainCategory(MainCategoryCode category) {
		return adminDao.selectDietsByMainCategory(category);
	}


	@Override
	@Transactional
	public boolean registerDailyDiets(AdminDietRegisterRequestDto requestDto) {

		List<DailyDiet> diets = new ArrayList<DailyDiet>();
		for(Integer dietId : requestDto.getDietIds()) {
			DailyDiet diet = new DailyDiet();
			diet.setDietId(dietId);
			diet.setStartDate(LocalDate.parse(requestDto.getStartDate()));
			diet.setEndDate(diet.getStartDate().plusDays(1));
			diets.add(diet);
		}
		if(adminDao.insertDailyDiets(diets) == requestDto.getDietIds().size()) {
			return true;
		};
		return false;
	}
	
	@Override
	public List<AdminDto> topList() {
		return adminDao.topList();
	}

	@Override
	public boolean approveCheck(long postId) {
		return adminDao.approveCheck(postId);
	}


}
