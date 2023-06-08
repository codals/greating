package com.codals.greating.admin.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codals.greating.admin.dao.AdminDao;
import com.codals.greating.admin.dto.AdminDailyDietResponseDto;
import com.codals.greating.admin.dto.AdminDietRegisterRequestDto;
import com.codals.greating.admin.dto.AdminDto;
import com.codals.greating.admin.dto.DiyToDietRequestDto;
import com.codals.greating.constant.CacheKey;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.Diet;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	private final AdminDao adminDao;

	
	@Override
	public List<Diet> getDietsByMainCategory(MainCategoryCode category) {
		return adminDao.selectDietsByMainCategory(category);
	}

	@Override
	@Transactional
	public boolean registerDailyDiets(AdminDietRegisterRequestDto requestDto) {
		int selectedCnt = requestDto.getDietIds().size();

		// 1. 저장할 DailyDiets 객체 생성
		List<DailyDiet> diets = new ArrayList<DailyDiet>();
		for (Integer dietId : requestDto.getDietIds()) {
			DailyDiet diet = DailyDiet.builder().dietId(dietId).startDate(LocalDate.parse(requestDto.getStartDate()))
					.endDate(LocalDate.parse(requestDto.getStartDate()).plusDays(1)).build();
			diets.add(diet);
		}

		// 2. DAO를 활용하여 데이터 저장
		int resultCnt = adminDao.insertDailyDiets(diets);

		if (resultCnt == selectedCnt) {
		    return true;
		}
		return false;
	}


	@Override
	public List<AdminDailyDietResponseDto> getDailyDietsByDate(String targetDate) {
		List<AdminDailyDietResponseDto> result = adminDao.selectDailyDietsByDate(targetDate);
		return result;
	}

	@Override
	public List<AdminDto> topList() {
		return adminDao.topList();
	}

	@Override
	public boolean approveCheck(int postId) {
		return adminDao.approveCheck(postId);
	}

	@Override
	public List<AdminDto> commingSoonList() {
		return adminDao.commingSoonList();
	}

//	@Override
//	public boolean delete(long postId) {
//		return adminDao.approveCancel(postId);
//	}
//
//
//

//	@Override
//	public boolean approveDiyCancel(long postId) {
//		return adminDao.approveDiyCancel(postId);
//	}

	@Override
	public boolean approveDiyRegister(int postId) {
		return adminDao.approveDiyRegister(postId);
	}

	@Override
	public List<AdminDto> allList() {
		return adminDao.allList();
	}

	// 정식상품 취소 
	@Override
	public boolean cancelDiet(int postId) {
		try {
			adminDao.updatePostStatusToReady(postId);
			adminDao.deleteDietByPost(postId);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	@Transactional
	public boolean diyToDiet(DiyToDietRequestDto requestDto) {
		try {
			adminDao.updatePostStatusToDiet(requestDto.getPostId());
			adminDao.insertPostToDiet(requestDto);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean approveCancel(int postId) {
		return adminDao.approveCancel(postId);
	}

	@Override
	public boolean deletePost(int postId) {
		return adminDao.deletePost(postId);
	}



}
