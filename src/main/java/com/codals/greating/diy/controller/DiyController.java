package com.codals.greating.diy.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.service.DiyService;

import lombok.RequiredArgsConstructor;


import com.codals.greating.diy.dto.FoodSimpleDto;
import com.codals.greating.diy.service.DiyService;
import com.codals.greating.food.FoodType;
import com.codals.greating.food.service.FoodService;

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
	public String loadTop10Page() {
		return "diy/diy-top10";
	}

	@GetMapping("/new")
	public String loadCreatePage(Model model) {
		
		List<FoodSimpleDto> rices = foodService.loadFoodsByFoodType(FoodType.RICE.getId());
		model.addAttribute("rices", rices);
		
		List<FoodSimpleDto> soups = foodService.loadFoodsByFoodType(FoodType.SOUP.getId());
		model.addAttribute("soups", soups);
		
		List<FoodSimpleDto> mains = foodService.loadFoodsByFoodType(FoodType.MAIN.getId());
		model.addAttribute("mains", mains);
		
		List<FoodSimpleDto> sides = foodService.loadFoodsByFoodType(FoodType.SIDE.getId());
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
		
		return "diy/diy-detail";
	}
}
