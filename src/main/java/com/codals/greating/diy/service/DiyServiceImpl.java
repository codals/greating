package com.codals.greating.diy.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codals.greating.aop.ExecutionTime;
import com.codals.greating.constant.CacheKey;
import com.codals.greating.diy.SearchCodeBuilder;
import com.codals.greating.diy.dao.DiyDAO;
import com.codals.greating.diy.dto.CommentResponseDto;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.PostStaticResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.dto.SearchRequestDto;
import com.codals.greating.diy.dto.SearchResponseDto;
import com.codals.greating.diy.dto.SimplePostDto;
import com.codals.greating.diy.entity.Comment;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.user.entity.User;
import com.codals.greating.diy.dto.VoteRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class DiyServiceImpl implements DiyService{
	
	private final DiyDAO diyDAO;
	private final SearchCodeBuilder searchCodeBuilder;
	private final RedisTemplate<String, Object> redisTemplate;
	
    @Value("${img.storage.path}")
    private String imgStoragePath;
    
    @Value("${img.api.token}")
    private String imgApiToken;
	
    
	@Override
	public PostResponseDto getPostDetail(int postId) {
		return diyDAO.selectPostByPostId(postId);
	}
	
	private Post createPost(User loginUser, DiyRequestDto postRequest) {    	
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
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* Redis 캐싱하기 */
	@Override 
    @ExecutionTime
	public List<Post> loadPostsByCategoryType(int mainCategoryId) {
		String cacheKey = CacheKey.TOP_10_CACHE_KEY + mainCategoryId;
		List<Post> result = null;

		List<Post> cachedData = getCachedPostsByCategoryType(cacheKey);
		if(cachedData != null){ //캐시에 이미 있는 경우 
	        log.info("[REDIS] TOP_10 - Cache Hit - {}", cacheKey);
			return cachedData;
		}
		// 캐시된 데이터가 없는 경우 
        log.info("[REDIS] TOP_10 - Cache Miss - {}", cacheKey);
		result = diyDAO.selectPostsByMainCategory(mainCategoryId);
		cacheTop10Posts(cacheKey, result);
		return result;
		
	}

    @ExecutionTime
	private List<Post> getCachedPostsByCategoryType(String cacheKey){
		return (List<Post>) redisTemplate.opsForValue().get(cacheKey);
	}
	
	private void cacheTop10Posts(String cacheKey, List<Post> cachingData) {
		redisTemplate.opsForValue().set(cacheKey,cachingData, 1, TimeUnit.DAYS);
        log.info("[REDIS] TOP_10 - Cache 저장 - {}", cacheKey);
	}
	
	@Override
    @ExecutionTime
	public SearchResponseDto search(SearchRequestDto requestDto) {
		// 1. pagination 설정
		int rowsPerPage = 9;
		requestDto.setStartRow((requestDto.getPage() - 1) * rowsPerPage);
		requestDto.setEndRow(rowsPerPage);
	
		// 2. 캐시 활용을 위한 cache key 생성
		String searchCode = searchCodeBuilder.buildCode(requestDto);
		String dataCacheKey = CacheKey.SEARCH_CODE_CACHE_KEY + searchCode + requestDto.getPage();
		String totalCntCacheKey = CacheKey.SEARCH_CODE_TOTAL_CNT_CODE_CACHE_KEY + searchCode;
		
		// 3. 캐시에서 데이터 가져오기
		List<SimplePostDto> searchResult;
		int totalCount;

		List<SimplePostDto> cachedData = getcachedSearchResult(dataCacheKey);
		if (cachedData != null) {
			searchResult = cachedData;
			totalCount = getcachedTotalCnt(totalCntCacheKey);
	        log.info("[REDIS] SEARCH - Cache Hit - {}", dataCacheKey);
	        log.info("[REDIS] SEARCH - Cache Hit - {}", totalCntCacheKey);
		} else {
			searchResult = diyDAO.selectPostBySearchConditions(requestDto);
			totalCount = diyDAO.getTotalSearchResultCount(requestDto);
			cacheSearchResult(dataCacheKey, searchResult);
			cacheTotalCnt(totalCntCacheKey, totalCount);
            log.info("[REDIS] SEARCH - Cache Miss - {}", dataCacheKey);
            log.info("[REDIS] SEARCH - Cache Miss - {}", totalCntCacheKey);
		}

		SearchResponseDto response = SearchResponseDto.builder()
				  .page(requestDto.getPage())
				  .totalCount(totalCount)
				  .totalPage((int) Math.ceil((double) totalCount / rowsPerPage))
				  .posts(searchResult)
				  .build();
		
		return response;
	}

	@ExecutionTime
	private List<SimplePostDto> getcachedSearchResult(String cacheKey) {
		@SuppressWarnings("unchecked")
		List<SimplePostDto> cachedData = (List<SimplePostDto>) redisTemplate.opsForValue().get(cacheKey);
	    return cachedData;
	}

	@ExecutionTime
	private int getcachedTotalCnt(String cacheKey) {
		@SuppressWarnings("unchecked")
		int cachedData = (int) redisTemplate.opsForValue().get(cacheKey);
		return cachedData;
	}

	private void cacheSearchResult(String cacheKey, List<SimplePostDto> result) {
		redisTemplate.opsForValue().set(cacheKey, result, 60, TimeUnit. MINUTES);
	    log.info("[REDIS] SEARCH - Cache 저장 - {}", cacheKey);
	}

    private void cacheTotalCnt(String cacheKey, int totalCount) {
    	redisTemplate.opsForValue().set(cacheKey, totalCount, 60, TimeUnit. MINUTES);
	    log.info("[REDIS] SEARCH - Cache 저장 - {}", cacheKey);
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
		// 1. 저장할 포스트 생성
		Post post = createPost(loginUser, postRequest);
		
		// 2. DB에 저장 후, 새로 생성된 postId 반환 
		Integer newPostId = diyDAO.savePost(post);
		return newPostId;
	}

	@Override
	@Scheduled(cron = "0 0 12 * * *")
	@Transactional
	public void updateExpiredPostStatus() {
		int updateCount = diyDAO.updateExpiredPostStatus();
		log.info("Expired Post Status Update Job executed. Updated status for {} posts.", updateCount);
}
  
  @Override
  public List<SimplePostDto> getRelatedPosts(int subCategoryId) {
		return diyDAO.selectPostsBySubCategory(subCategoryId);
	}

	@Override
	public PostStaticResponseDto getPostVoteStatics(int postId) {
		return diyDAO.selectPostVoteStatics(postId);
	}


	@Override
	public List<CommentResponseDto> getComments(int postId){
		return diyDAO.selectComments(postId);
	}


	@Override
	@Transactional
	public boolean updateComment(Comment comment) {
		try {
			if(diyDAO.updateComment(comment)==1) {
				return true;
			}
			log.warn("댓글 업데이트 실패입니다.");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(rollbackFor = {Exception.class}) // 리팩터링 필요 
	public CommentResponseDto createComment(Comment comment) {
		try {
			int insertedCommentId = diyDAO.insertComment(comment);
			CommentResponseDto result = diyDAO.selectCommentById(insertedCommentId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	@Transactional
	public boolean deleteComment(int commentId) {
		if(diyDAO.deleteCommentById(commentId)==1) {
			return true;
		}
		return false;
	}
}
