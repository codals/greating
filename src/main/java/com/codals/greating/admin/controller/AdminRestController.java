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
	public ResponseEntity<Boolean> registerDailyDiets(@RequestBody AdminDietRegisterRequestDto requestDto){

		log.info(requestDto);
		
		if(adminService.registerDailyDiets(requestDto)) {
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
}
