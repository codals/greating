package com.codals.greating.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codals.greating.admin.dto.AdminDailyDietResponseDto;
import com.codals.greating.admin.dto.AdminDietRegisterRequestDto;
import com.codals.greating.admin.dto.DiyToDietRequestDto;
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

		List<Diet> diets = adminService.getDietsByMainCategory(category);
		return new ResponseEntity<>(diets, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Boolean> registerDailyDiets(@RequestBody AdminDietRegisterRequestDto requestDto) {
		if (adminService.registerDailyDiets(requestDto)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	    return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
  }
	// 출시 예정 상품으로 등록 
	@PostMapping("/approve")
	public ResponseEntity<Boolean> changeStatus(@RequestParam("postId") int postId) {
		if(adminService.approveCheck(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	
	// 출시 예정 상품 취소 
	@PostMapping("/approveCancel")
	public ResponseEntity<Boolean> changeStatusCancel(@RequestParam("postId") int postId) {
		if(adminService.approveCancel(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}

	@GetMapping("/daily-diets")
	public ResponseEntity<List<AdminDailyDietResponseDto>> getDailyDiets(String date) {
		List<AdminDailyDietResponseDto> diets = adminService.getDailyDietsByDate(date);
		return new ResponseEntity<>(diets, HttpStatus.OK);
	}
	
	
	
//	@PostMapping("/approveDiy")
//	public ResponseEntity<Boolean> approveDiy(@RequestParam("postId") long postId) {
//		if(adminService.approveDiy(postId)) {
//			return ResponseEntity.ok().build(); 
//		}
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
//	}
	
	
	@PostMapping("/registerDiy")
	public ResponseEntity<Boolean> approveDiyRegister(@RequestParam("postId") int postId) {
		if(adminService.approveDiyRegister(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	
//	@PostMapping("/approveDiyCancel")
//	public ResponseEntity<Boolean> changeDiy(@RequestParam("postId") long postId) {
//	    adminService.approveDiyCancel(postId);
//	    boolean success = adminService.approveDiy(postId);
//	    if (success) {
//	        return ResponseEntity.ok().build(); 
//	    } else {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
//	    }
//	}

    @DeleteMapping("/{postId}")
    public ResponseEntity<Boolean> deleteDiy(@PathVariable("postId") int postId) {
    	if(adminService.deletePost(postId)) {
			return ResponseEntity.ok().build(); 
    	}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);

    }

	
	// 정식 상품 등록 취소
	@PostMapping("/cancel-diet")
	public ResponseEntity<Boolean> cancelDiet(int postId) {
		if(adminService.cancelDiet(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	//정식 상품 등록 
	@PostMapping("/diytodiet")
	public ResponseEntity<Boolean> diyToDiet(DiyToDietRequestDto requestDto) {
		if(adminService.diyToDiet(requestDto)) {
		  return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);

	}


	
}

