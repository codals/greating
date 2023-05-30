package com.codals.greating.diy.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codals.greating.diy.dto.DiyRequestDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/mealdiy")
public class DiyRestController {

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
    public String createNewPost(/* @SessionAttribute("loginUser") User loginUser, */
                                @ModelAttribute DiyRequestDto newPost) {
    	
        /* log.info(loginUser); */
        log.info(newPost);
        
        return "/greating/mealdiy/" + "1";
    }
}
