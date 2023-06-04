package com.codals.greating.mypage.controller;

import static com.codals.greating.constant.SessionKey.LOGIN_USER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codals.greating.mypage.dto.MyPageDto;
import com.codals.greating.mypage.dto.MyPageScrapDto;
import com.codals.greating.mypage.service.MyPageService;
import com.codals.greating.user.entity.User;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	@Autowired
	MyPageService service;
    
    
    @GetMapping("/main")
    public String myPage(@SessionAttribute("loginUser") User loginUser, Model model) {

        // 세션에서 로그인된 사용자 정보 가져오기
    	model.addAttribute("username", loginUser.getUsername());
       
        // 사용자 정보를 모델에 추가하여 화면에 표시
        
        model.addAttribute("email", loginUser.getEmail());
        
        return "user/mypage-welcome";


    }
    

    @GetMapping("/dietsList")
    public List<MyPageDto> loadMyDietPageList() {
    	
    	
        return null;
    }
    
    @GetMapping("/diets")
    public String loadMyDietPage(@SessionAttribute("loginUser") User loginUser, MyPageDto dto,
    		@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

    	// 사용자 ID를 가져와서 dto에 설정
        dto.setUserId(loginUser.getId());
        
        // dto를 기반으로 사용자의 글 목록을 조회
        List<MyPageDto> dietList = service.diyList(dto, page);
        
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
        List<MyPageDto> scrapList = service.scrapList(dto, page);
        
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
        List<MyPageDto> voteList = service.voteList(dto, page);
        
        model.addAttribute("dto", dto);
        model.addAttribute("list", voteList);
        return "user/mypage-myvote";
    }

    @GetMapping("/profile")
    public String loadProfilePage() {
        /**
         * my-profile.jsp 예정
         */
        return "mypage/my-profile";
    }
}
