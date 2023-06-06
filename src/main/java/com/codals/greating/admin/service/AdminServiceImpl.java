package com.codals.greating.admin.service;


import java.time.LocalDate;
import java.util.ArrayList;
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
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.Diet;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
	
	private final String DAILY_DIET_CACHE_KEY = "dailyDiets: ";
	
	private final AdminDao adminDao;
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
		    cacheDailyDiet(requestDto.getStartDate());	// Redis에 캐싱하기 (이미 key가 있어도 업데이트된 데이터로 덮어씌움)
		    return true;
		}
		return false;
	}
	
	private void cacheDailyDiet(String targetDate) {
		String cacheKey = DAILY_DIET_CACHE_KEY + targetDate;
	    List<AdminDailyDietResponseDto> cachingDiets = adminDao.selectDailyDietsByDate(targetDate);
		
	    redisTemplate.opsForValue().set(cacheKey, cachingDiets, 14, TimeUnit.DAYS);
	    
	    log.info("일일 식단 데이터를 Redis에 저장: {}", cacheKey);
	}


	@Override
	public List<AdminDailyDietResponseDto> getDailyDietsByDate(String targetDate) {
		
		List<AdminDailyDietResponseDto> result = null;
		
		
		List<AdminDailyDietResponseDto> cachedData = getCachedDailyDietsByDate(targetDate);
		if (cachedData != null) {	// 1. 캐시된 데이터가 있으면 캐시에서 가져오기 (Cache Hit)
			result = cachedData;
	        log.info("일일 식단 데이터를 Redis에서 가져옴: {}", targetDate);
	        
		} else {					// 2. 캐시된 데이터가 없으면, DB에서 가져오기
			result =  adminDao.selectDailyDietsByDate(targetDate);
		}
		
		log.info("result {} ", result);
		return result;
	}
	
	private List<AdminDailyDietResponseDto> getCachedDailyDietsByDate(String targetDate) {
	    String cacheKey = DAILY_DIET_CACHE_KEY + targetDate;
	    List<AdminDailyDietResponseDto> cachedData = (List<AdminDailyDietResponseDto>) redisTemplate.opsForValue().get(cacheKey);	    
	    return cachedData;
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
		// TODO Auto-generated method stub
		return adminDao.commingSoonList();
	}


	@Override
	public boolean approveCancel(long postId) {
		// TODO Auto-generated method stub
		return adminDao.approveCancel(postId);
	}


}
