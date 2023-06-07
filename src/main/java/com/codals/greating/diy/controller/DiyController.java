package com.codals.greating.diy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diy.dto.CommentResponseDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.dto.SimplePostDto;
import com.codals.greating.diy.dto.VoteRequestDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.diy.service.DiyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import com.codals.greating.food.dto.FoodDetailDto;
import com.codals.greating.food.dto.FoodSimpleDto;
import com.codals.greating.food.service.FoodService;
import com.codals.greating.user.entity.User;

import static com.codals.greating.constant.FoodTypeCode.*;

@Log4j2
@Controller
@RequestMapping("/mealdiy")
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class DiyController {
	
	private final DiyService diyService;
	
	private final FoodService foodService;
	
	@Value("${img.upload.url}")
    private String imgUploadUrl;
	
	@Value("${img.api.token}")
	private String imgApiToken;

	@Value("${img.storage.path}")
    private String imgStoragePath;
	
	@Value("${kakao.share.key}")
	private String kakaoShareKey;
	
	@GetMapping
	public String loadMainPage(Model model) {
		List<Post> healthyPostTop10 = diyService.loadPostsByCategoryType(MainCategoryCode.HEALTHY_DIET.getId());
		model.addAttribute("healthyPostTop10", healthyPostTop10);
		return "diy/diy-main-new";
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
	public String loadPostDetailPage(@PathVariable int postId, @SessionAttribute("loginUser") User loginUser, Model model) {
		
		// 투표한 이력이 있는 지
		boolean isVoted = diyService.checkVoted(new VoteRequestDto(postId, loginUser.getId()));
		model.addAttribute("isVoted", isVoted);
		
		// 스크랩한 이력이 있는 지 
		boolean isScrapped = diyService.checkScrapped(new ScrapRequestDto(postId, loginUser.getId()));
		model.addAttribute("isScrapped", isScrapped);
		
		PostResponseDto postDetail = diyService.getPostDetail(postId);
		model.addAttribute("postDetail", postDetail);
		
		
		// 관련된 포스트 
		List<SimplePostDto> relatedPosts = diyService.getRelatedPosts(postDetail.getMainCategory().getId());
		model.addAttribute("relatedPosts", relatedPosts);
		
		// 랜덤 건강 마켓 상품 
		List<FoodSimpleDto> relatedFoods = foodService.loadMarketFoodByRandom();
		model.addAttribute("relatedFoods", relatedFoods);
		
		// 댓글 
		List<CommentResponseDto> comments = diyService.getComments(postId);
		log.info("comments {} ", comments);
		model.addAttribute("comments", comments);
		
		model.addAttribute("imgApiToken", imgApiToken);
		
		model.addAttribute("kakaoShareKey", kakaoShareKey);
		log.info(postDetail);
		return "diy/diy-detail";
	}
	
}
