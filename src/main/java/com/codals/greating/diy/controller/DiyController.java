package com.codals.greating.diy.controller;

import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.diy.service.DiyService;

import lombok.RequiredArgsConstructor;

import com.codals.greating.food.dto.FoodDetailDto;
import com.codals.greating.food.dto.FoodSimpleDto;
import com.codals.greating.food.service.FoodService;
import static com.codals.greating.constant.FoodTypeCode.*;

@Controller
@RequestMapping("/mealdiy")
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class DiyController {
	
	Logger log = LogManager.getLogger("case3");


	private final DiyService diyService;
	
	private final FoodService foodService;
	
	@Value("${img.upload.url}")
    private String imgUploadUrl;
	
	@Value("${img.api.token}")
	private String imgApiToken;
	
	@GetMapping
	public String loadMainPage() {
		return "diy/diy-main";
	}

	@GetMapping("/popular")
	public String loadTop10Page(Model model) {
		
		List<Post> healthyPostTop10 = diyService.loadPostsByCategoryType(MainCategoryCode.HEALTHY_DIET.getId());
		List<Post> medicalPostTop10 = diyService.loadPostsByCategoryType(MainCategoryCode.MEDICAL_DIET.getId());
		List<Post> callengePostTop10 = diyService.loadPostsByCategoryType(MainCategoryCode.CHALLENGE_DIET.getId());
		
		model.addAttribute("healthyPostTop10", healthyPostTop10);
		model.addAttribute("medicalPostTop10", medicalPostTop10);
		model.addAttribute("callengePostTop10", callengePostTop10);
		
		return "diy/diy-top10";
	}

	@GetMapping("/new")
	public String loadCreatePage(Model model) {
		
		model.addAttribute("imgUploadUrl", imgUploadUrl);
		model.addAttribute("imgApiToken", imgApiToken);
				
		List<FoodSimpleDto> rices = foodService.loadGreatingFoodsByFoodType(RICE.getId());
		model.addAttribute("rices", rices);
		
		List<FoodSimpleDto> soups = foodService.loadGreatingFoodsByFoodType(SOUP.getId());
		model.addAttribute("soups", soups);
		
		List<FoodSimpleDto> mains = foodService.loadGreatingFoodsByFoodType(MAIN.getId());
		model.addAttribute("mains", mains);
		
		List<FoodSimpleDto> sides = foodService.loadGreatingFoodsByFoodType(SIDE.getId());
		model.addAttribute("sides", sides);

		List<FoodDetailDto> marketSoups = foodService.loadMarketFoodsByFoodType(SOUP.getId());
		model.addAttribute("marketSoups", marketSoups);
		
		List<FoodDetailDto> marketMains = foodService.loadMarketFoodsByFoodType(MAIN.getId());
		model.addAttribute("marketMains", marketMains);
		
		List<FoodDetailDto> marketSides = foodService.loadMarketFoodsByFoodType(SIDE.getId());
		model.addAttribute("marketSides", marketSides);
		
		List<FoodDetailDto> marketExtras = foodService.loadMarketFoodsByFoodType(EXTRA.getId());
		model.addAttribute("marketExtras", marketExtras);
		
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
