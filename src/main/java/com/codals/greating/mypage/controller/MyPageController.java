package com.codals.greating.mypage.controller;

import static com.codals.greating.constant.SessionKey.COMPLETED_ORDER_CNT;

import com.codals.greating.diet.service.OrderService;
import java.util.List;

import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codals.greating.mypage.dto.MyPageDto;
import com.codals.greating.mypage.dto.MyPageScrapDto;
import com.codals.greating.mypage.service.MyPageService;
import com.codals.greating.user.entity.User;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

	private final MyPageService myPageService;
    private final OrderService orderService;

    @GetMapping("/diets")
    public String loadMyDietPage(@SessionAttribute("loginUser") User loginUser, MyPageDto dto,
    		@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

    	// 사용자 ID를 가져와서 dto에 설정
        dto.setUserId(loginUser.getId());
        
        // dto를 기반으로 사용자의 글 목록을 조회
        List<MyPageDto> dietList = myPageService.diyList(dto, page);
        
        model.addAttribute("dto", dto);
        model.addAttribute("list", dietList);
        return "user/mypage-mydiy";
    }

    @GetMapping("/scrap")
    public String loadMyScrapPage(@SessionAttribute("loginUser") User loginUser, MyPageScrapDto dto,
    		@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        
    	// 사용자 ID를 가져와서 dto에 설정
        dto.setUserId(loginUser.getId());
        
        // dto를 기반으로 사용자의 글 목록을 조회
        List<MyPageDto> scrapList = myPageService.scrapList(dto, page);
        
        model.addAttribute("dto", dto);
        model.addAttribute("list", scrapList);
    	
    	return "user/mypage-myscrap"; 
    }

    @GetMapping("/voted")
    public String loadMyVotedPage(@SessionAttribute("loginUser") User loginUser, MyPageScrapDto dto, 
    		@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
    	// 사용자 ID를 가져와서 dto에 설정
        dto.setUserId(loginUser.getId());
        
        // dto를 기반으로 사용자의 글 목록을 조회
        List<MyPageDto> voteList = myPageService.voteList(dto, page);
        
        model.addAttribute("dto", dto);
        model.addAttribute("list", voteList);
        return "user/mypage-myvote";
    }

    @GetMapping("/profile")
    public String loadProfilePage(@SessionAttribute("loginUser") User loginUser, HttpSession session) {
        int completedOrderCnt = orderService.getCompletedOrderCnt(loginUser.getId());
        session.setAttribute(COMPLETED_ORDER_CNT, completedOrderCnt);
        return "user/mypage-main";
    }
    
    @DeleteMapping("/deleteDiy/{id}")
    public ResponseEntity<Boolean> deleteMyDiy(@PathVariable("id") int id) {
    	myPageService.deleteMyDiy(id);
    	return ResponseEntity.ok(true);
    }

}
