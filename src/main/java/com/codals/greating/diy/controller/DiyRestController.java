package com.codals.greating.diy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostStaticResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.dto.SearchRequestDto;
import com.codals.greating.diy.dto.SimplePostDto;
import com.codals.greating.diy.dto.VoteRequestDto;
import com.codals.greating.diy.service.DiyService;
import com.codals.greating.user.entity.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mealdiy")
public class DiyRestController {
	
	private final DiyService diyService;

    @PostMapping
    public String search(@RequestParam(required = false) String category,
                         @RequestParam(required = false) String classification,
                         @RequestParam(required = false) boolean includeRice,
                         @RequestParam(required = false) boolean includeSoup) {
        /**
         * diy 메인 > 돋보기, 선택완료 버튼 (Ajax)
         */
        return "diy/diy-main";
    }
    
    @PostMapping("/new")
	public ResponseEntity<?> savePost(@SessionAttribute("loginUser") User loginUser,
									  @ModelAttribute DiyRequestDto postRequest,
							          HttpSession session) {

		log.info(postRequest);
		log.info("soupId=" + postRequest.getSoupFoodId());

		Integer postId = diyService.savePost(loginUser, postRequest);
				
		
	    return new ResponseEntity<>(postId, HttpStatus.OK);
	}
    
    @PostMapping("/scrap")
    public ResponseEntity<Boolean> scrap(int postId, @SessionAttribute("loginUser") User loginUser ){
    	if(diyService.scrap(new ScrapRequestDto(postId, loginUser.getId()))) {
			return ResponseEntity.ok().build();   
		}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }
    
    @DeleteMapping("/{postId}/scrap")
    public ResponseEntity<Boolean> cancelScrap(@PathVariable("postId") int postId, @SessionAttribute("loginUser") User loginUser){
    	if(diyService.cancelScrap(new ScrapRequestDto(postId, loginUser.getId()))) {
			return ResponseEntity.ok().build();   
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }
    
	


	@PostMapping("/vote")
	public ResponseEntity<Boolean>  votePost(int postId, @SessionAttribute("loginUser") User loginUser ){
		if(diyService.vote(new VoteRequestDto(postId, loginUser.getId()))) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	
	
	@DeleteMapping("/{postId}/vote")
	public ResponseEntity<Boolean> voteCancel(@PathVariable("postId") int postId, @SessionAttribute("loginUser") User loginUser ){
		
		if(diyService.cancelVote(new VoteRequestDto(postId, loginUser.getId()))) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<SimplePostDto>> search(SearchRequestDto requestDto) {
		List<SimplePostDto> searchedPosts = diyService.search(requestDto);	
	    return new ResponseEntity<>(searchedPosts, HttpStatus.OK);
	}
	
	@GetMapping("/statics")
	public ResponseEntity<PostStaticResponseDto> statics(int postId) {
		
		PostStaticResponseDto postStatics = diyService.getPostVoteStatics(postId);
		log.info("투표 통계 {}" ,postStatics);
	    return new ResponseEntity<>(postStatics, HttpStatus.OK);
		
	}

}
