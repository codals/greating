package com.codals.greating.admin.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codals.greating.admin.dto.AdminDailyDietResponseDto;
import com.codals.greating.admin.dto.AdminDietRegisterRequestDto;
import com.codals.greating.admin.service.AdminService;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diet.entity.Diet;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminRestController {

	private final AdminService adminService;

	@GetMapping("/register")
	public ResponseEntity<List<Diet>> getDietsByMainCategory(MainCategoryCode category) {

		log.info(category);
		List<Diet> diets = adminService.getDietsByMainCategory(category);
		log.info(diets);
		return new ResponseEntity<>(diets, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Boolean> registerDailyDiets(@RequestBody AdminDietRegisterRequestDto requestDto) {

		log.info(requestDto);

		if (adminService.registerDailyDiets(requestDto)) {
			return new ResponseEntity<>(true, HttpStatus.OK);

		}
		
	    return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
  }
	@PostMapping("/approve")
	public ResponseEntity<Boolean> changeStatus(@RequestParam("postId") long postId) {
		if(adminService.approveCheck(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	
	@PostMapping("/approveCancel")
	public ResponseEntity<Boolean> changeStatusCancel(@RequestParam("postId") long postId) {
		if(adminService.approveCancel(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}

	@GetMapping("daily-diets")
	public ResponseEntity<List<AdminDailyDietResponseDto>> getDailyDiets(String date) {

		log.info(date);
		List<AdminDailyDietResponseDto> diets = adminService.getDailyDietsByDate(date);
		log.info("controller diets{} ", diets);
		return new ResponseEntity<>(diets, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/approveDiy")
	public ResponseEntity<Boolean> approveDiy(@RequestParam("postId") long postId) {
		System.out.println("======approveDiy======");
		if(adminService.approveDiy(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	
	@PostMapping("/registerDiy")
	public ResponseEntity<Boolean> approveDiyRegister(@RequestParam("postId") int postId) {
		System.out.println("======approveDiyRegister======");
		System.out.println(postId);
		if(adminService.approveDiyRegister(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	
	@PostMapping("/approveDiyCancel")
	public ResponseEntity<Boolean> changeDiy(@RequestParam("postId") long postId) {
		System.out.println("======changeDiy======");
		if(adminService.approveDiyCancel(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	
	
}

