package com.codals.greating.diy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.VoteRequestDTO;
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
	public String createPost(@SessionAttribute("loginUser") User loginUser,
								@ModelAttribute DiyRequestDto newPost,
								HttpSession session) {

		
		/* log.info(loginUser); */
		log.info(newPost);

		// 톰캣 아래 바로 이미지 넣는 경로
		String path = session.getServletContext().getRealPath("/") + "resources/images";

		diyService.createPost(newPost, path);

		return "/greating/mealdiy/" + "1";
	}
	


	@PostMapping("/vote")
	public ResponseEntity<Boolean>  votePost(VoteRequestDTO requestDTO) {
		if(diyService.votePost(requestDTO)==1) {
			return ResponseEntity.ok().build();

		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
	
}
