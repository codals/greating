package com.codals.greating.admin.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codals.greating.admin.dao.AdminDao;
import com.codals.greating.admin.dto.AdminDailyDietResponseDto;
import com.codals.greating.admin.dto.AdminDietRegisterRequestDto;
import com.codals.greating.admin.dto.AdminDto;
import com.codals.greating.constant.CacheKey;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.dao.DailyDietDao;
import com.codals.greating.diet.dto.PreviewResponseDto;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.Diet;
import com.codals.greating.util.DateUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{	
	private final AdminDao adminDao;
	private final DailyDietDao dailyDietDao;
	private final RedisTemplate<String, Object> redisTemplate;
	
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
		for(Integer dietId : requestDto.getDietIds()) {
			DailyDiet diet = DailyDiet.builder()
									  .dietId(dietId)
									  .startDate(LocalDate.parse(requestDto.getStartDate()))
									  .endDate(LocalDate.parse(requestDto.getStartDate()).plusDays(1))
									  .build();
			diets.add(diet);
		}

		// 2. DAO를 활용하여 데이터 저장
		int resultCnt = adminDao.insertDailyDiets(diets);
		if (resultCnt == selectedCnt) {					// 개수대로 제대로 저장이 되었으면
			cacheTwoWeekDailyDiets(requestDto.getStartDate());	// Redis에 캐싱하기 (이미 key가 있어도 업데이트된 데이터로 덮어씌움)
		    return true;
		}
		return false;
	}
	
	private void cacheTwoWeekDailyDiets(String targetDate) {
		String cacheKey = CacheKey.TWO_WEEK_PREVIEW_CACHE_KEY + targetDate;
	    List<DailyDiet> cachingDiets = dailyDietDao.selectAllByStartDate(DateUtil.dateToString(new Date()));
	    redisTemplate.opsForValue().set(cacheKey, cachingDiets, 1, TimeUnit.DAYS);
	    log.info("[REDIS] TWO_WEEK_PREVIEW - Cache 저장 - {}", cacheKey);
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
	public boolean approveCheck(long postId) {
		return adminDao.approveCheck(postId);
	}


	@Override
	public List<AdminDto> commingSoonList() {
		return adminDao.commingSoonList();
	}


	@Override
	public boolean approveCancel(long postId) {
		return adminDao.approveCancel(postId);
	}


	@Override
	public boolean approveDiy(long postId) {
		return adminDao.approveDiy(postId);
	}


	@Override
	public boolean approveDiyCancel(long postId) {
		return adminDao.approveDiyCancel(postId);
	}


	@Override
	public boolean approveDiyRegister(int postId) {
		return adminDao.approveDiyRegister(postId);
	}


	@Override
	public boolean submitPrice(int postId, int price) {
		return adminDao.submitPrice(postId,price);
	}


}
