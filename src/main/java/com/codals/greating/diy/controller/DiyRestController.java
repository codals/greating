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

import com.codals.greating.diy.dto.CommentResponseDto;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostStaticResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.dto.SearchRequestDto;
import com.codals.greating.diy.dto.SearchResponseDto;
import com.codals.greating.diy.dto.VoteRequestDto;
import com.codals.greating.diy.entity.Comment;
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
    
    @PostMapping("/new")
	public ResponseEntity<Integer> savePost(@SessionAttribute("loginUser") User loginUser,
									  @ModelAttribute DiyRequestDto postRequest) {

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

  @PostMapping("/comment-new")
	public ResponseEntity<CommentResponseDto> createComment(Comment comment){

		CommentResponseDto newComment = diyService.createComment(comment);
		if(newComment!=null) {
			return new ResponseEntity<>(newComment, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
    @DeleteMapping("/{commentId}/comment")
	public ResponseEntity<Boolean> deleteComment(@PathVariable("commentId") int commentId){
    	if(diyService.deleteComment(commentId)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }
	
	@PostMapping("/comment-update")
	public ResponseEntity<Boolean> updateComment(Comment comment){
		if(diyService.updateComment(comment)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	   
	}
  
	@GetMapping("/search")
	public ResponseEntity<SearchResponseDto> search(SearchRequestDto requestDto, @RequestParam(value = "page", defaultValue = "1") int page) {
		requestDto.setPage(page);
		SearchResponseDto response = diyService.search(requestDto);	
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/statics")
	public ResponseEntity<PostStaticResponseDto> statics(int postId) {
		
		PostStaticResponseDto postStatics = diyService.getPostVoteStatics(postId);
	    return new ResponseEntity<>(postStatics, HttpStatus.OK);
		
	}

}
