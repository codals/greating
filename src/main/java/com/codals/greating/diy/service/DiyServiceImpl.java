package com.codals.greating.diy.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.codals.greating.diy.dao.DiyDAO;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.user.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiyServiceImpl implements DiyService{

	Logger log = LogManager.getLogger("case3");
	
	private final DiyDAO diyDAO;
	
	@Override
	public PostResponseDto getPostDetail(int postId) {
		return diyDAO.selectPostByPostId(postId);
	}
	
	private Post createPost(User loginUser, DiyRequestDto postRequest) {
		
		log.info("request -> post 매핑 전 =" + postRequest);
		
		Post newPost = Post.builder()
							.mainCategoryId(postRequest.getMainCategoryId())
							.subCategoryId(postRequest.getSubCategoryId())
							.foodCountryId(postRequest.getFoodCountryId())
							.userId(loginUser.getId())
							.title(postRequest.getDietName())
							.content(postRequest.getContent())
							.imgUrl(postRequest.getFileName())
							.riceFoodId(postRequest.getRiceFoodId())
							.soupFoodId(postRequest.getSoupFoodId())
							.mainFoodId(postRequest.getMainFoodId())
							.side1FoodId(postRequest.getSideFoodIds().size() >= 1 ? postRequest.getSideFoodIds().get(0) : null)
							.side2FoodId(postRequest.getSideFoodIds().size() >= 2 ? postRequest.getSideFoodIds().get(1) : null)
							.minCalorie(postRequest.getMinCalorie())
							.maxCalorie(postRequest.getMaxCalorie())
							.minPrice(postRequest.getMinPrice())
							.maxPrice(postRequest.getMaxPrice())
							.build();

		log.info("request -> post 매핑 후 =" + newPost);

		return newPost;
	}

	@Override
	public int savePost(User loginUser, DiyRequestDto postRequest) {
		// 1. 파일명 생성해서 받아오기 (tomcat서버에 저장된 경로 + UUID로 만든 파일명 + 확장자)
		
		// 2. post 객체 생성하기
		Post post = createPost(loginUser, postRequest);
		
		// 3. post DB에 저장하기
		return diyDAO.savePost(post);
	}
}
