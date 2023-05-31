package com.codals.greating.diy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codals.greating.constant.FoodTypeCode;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.diy.service.DiyService;

import lombok.RequiredArgsConstructor;

import com.codals.greating.diy.service.DiyService;
import com.codals.greating.food.dto.FoodSimpleDto;
import com.codals.greating.food.service.FoodService;
import com.codals.greating.user.entity.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mealdiy")
@RequiredArgsConstructor
public class DiyController {
	
	Logger log = LogManager.getLogger("case3");


	private final DiyService diyService;
	
	private final FoodService foodService;

//	@ModelAttribute("rices")
//	public List<FoodSimpleDto> loadAllRices() {
//		return diyService.loadAllRices();
//	}
	
	@GetMapping
	public String loadMainPage() {
		return "diy/diy-main";
	}

	@GetMapping("/popular")
	public String loadTop10Page(Model model) {
		
		List<Post> healthyPostTop10 = diyService.loadPostsByCategoryType(MainCategoryCode.HEALTHY_DIET.getId());
		List<Post> medicalPostTop10 = diyService.loadPostsByCategoryType(MainCategoryCode.MEDICAL_DIET.getId());
		List<Post> callengePostTop10 = diyService.loadPostsByCategoryType(MainCategoryCode.CHALLENGE_DIET.getId());
		
		log.info(healthyPostTop10);
		log.info(medicalPostTop10);
		log.info(callengePostTop10);
		
		model.addAttribute("healthyPostTop10", healthyPostTop10);
		model.addAttribute("medicalPostTop10", medicalPostTop10);
		model.addAttribute("callengePostTop10", callengePostTop10);
		
		return "diy/diy-top10";
	}

	@GetMapping("/new")
	public String loadCreatePage(Model model) {
		
		List<FoodSimpleDto> rices = foodService.loadFoodsByFoodType(FoodTypeCode.RICE.getId());
		model.addAttribute("rices", rices);
		
		List<FoodSimpleDto> soups = foodService.loadFoodsByFoodType(FoodTypeCode.SOUP.getId());
		model.addAttribute("soups", soups);
		
		List<FoodSimpleDto> mains = foodService.loadFoodsByFoodType(FoodTypeCode.MAIN.getId());
		model.addAttribute("mains", mains);
		
		List<FoodSimpleDto> sides = foodService.loadFoodsByFoodType(FoodTypeCode.SIDE.getId());
		model.addAttribute("sides", sides);
		
		log.info(rices);
		log.info(soups);
		log.info(mains);
		log.info(sides);
		
		return "diy/diy-create";
	}

	@GetMapping("/{postId}")
	public String loadPostDetailPage(@PathVariable int postId, Model model) {
		log.debug("start post detail ");
		
		PostResponseDto postDetail = diyService.getPostDetail(postId);
		model.addAttribute("postDetail", postDetail);
		
		log.info(postDetail.getPost());
		
		return "diy/diy-detail";
	}
	
}
