package com.codals.greating.diy.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codals.greating.diy.dao.DiyDAO;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.dto.SearchRequestDto;
import com.codals.greating.diy.dto.SimplePostDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.user.entity.User;
import com.codals.greating.util.ImageUrlGenerator;
import com.codals.greating.diy.dto.VoteRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class DiyServiceImpl implements DiyService{

	Logger log = LogManager.getLogger("case3");
	
	private final DiyDAO diyDAO;
	
    @Value("${img.storage.path}")
    private String imgStoragePath;
    
    @Value("${img.api.token}")
    private String imgApiToken;
	
    private final RedisTemplate<String, Object> redisTemplate;
    
	@Override
	public PostResponseDto getPostDetail(int postId) {
		
		ValueOperations<String, Object> list = redisTemplate.opsForValue();
		
		if(redisTemplate.hasKey("testing")){
			System.out.println("==============================================");
			System.out.println("testing 키가 이미 있음");
			System.out.println("==============================================");
			System.out.println("데이터 확인 " + list.get("testing"));
		}else {
			System.out.println("==============================================");
			System.out.println(" 키가 없음");
			PostResponseDto value = diyDAO.selectPostByPostId(postId);
			list.set("testing", value, 300, TimeUnit.SECONDS); //키 유효시간 300초로 설정
			System.out.println("Redis에" + " 키 저장");
			System.out.println("==============================================");
		}
		
		
		return diyDAO.selectPostByPostId(postId);
	}
	
	
	private Post createPost(User loginUser, DiyRequestDto postRequest) {
		
		log.info("request -> post 매핑 전 =" + postRequest);
		log.info("path=" + imgStoragePath);
    	log.info("token=" + imgApiToken);
    	
		Post newPost = Post.builder()
							.mainCategoryId(postRequest.getMainCategoryId())
							.subCategoryId(postRequest.getSubCategoryId())
							.foodCountryId(postRequest.getFoodCountryId())
							.userId(loginUser.getId())
							.username(loginUser.getUsername())
							.title(postRequest.getDietName())
							.content(postRequest.getContent())
							.imgUrl(imgStoragePath + "/" + postRequest.getFileName())
							.riceFoodId(postRequest.getRiceFoodId())
							.soupFoodId(postRequest.getSoupFoodId())
							.mainFoodId(postRequest.getMainFoodId())
							.side1FoodId((postRequest.getSideFoodIds() != null && postRequest.getSideFoodIds().size() >= 1) ? postRequest.getSideFoodIds().get(0) : null)
							.side2FoodId((postRequest.getSideFoodIds() != null && postRequest.getSideFoodIds().size() >= 2) ? postRequest.getSideFoodIds().get(1) : null)
							.minCalorie(postRequest.getMinCalorie())
							.maxCalorie(postRequest.getMaxCalorie())
							.minPrice(postRequest.getMinPrice())
							.maxPrice(postRequest.getMaxPrice())
							.build();

		log.info("request -> post 매핑 후 =" + newPost);

		return newPost;
	}

    @Override
	@Transactional
	public boolean vote(VoteRequestDto requestDto) {
		try {
			if(diyDAO.insertVote(requestDto)==1) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

  @Override
  @Transactional
  public boolean cancelVote(VoteRequestDto requestDto) {
    try {
      if(diyDAO.deleteVote(requestDto)==1) {
        return true;
      }
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  
  @Override
	@Transactional
	public boolean scrap(ScrapRequestDto requestDto) {
		try {
			if(diyDAO.insertScrap(requestDto)==1) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean cancelScrap(ScrapRequestDto requestDto) {
		try {
			if(diyDAO.deleteScrap(requestDto)==1) {
				return true;
			}
			log.warn("해당 scrap 데이터가 없습니다.");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Post> loadPostsByCategoryType(int mainCategoryId) {
		return diyDAO.selectPostsByMainCategory(mainCategoryId);
	}

	@Override
	public List<SimplePostDto> search(SearchRequestDto requestDto) {

		return diyDAO.selectPostBySearchConditions(requestDto);
	}

	@Override
	public boolean checkVoted(VoteRequestDto requestDto) {

		if(diyDAO.selectVoteByPostIdAndUserId(requestDto)!= null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkScrapped(ScrapRequestDto requestDto) {
		if(diyDAO.selectScrapByPostIdAndUserId(requestDto)!= null) {
			return true;
		}
		return false;
	}
      
	@Override
	public Integer savePost(User loginUser, DiyRequestDto postRequest) {
		// 1. 파일명 생성해서 받아오기 (tomcat서버에 저장된 경로 + UUID로 만든 파일명 + 확장자)
		
		// 2. post 객체 생성하기
		Post post = createPost(loginUser, postRequest);
		
		// 3. post DB에 저장하기
		return diyDAO.savePost(post);
	}
}
