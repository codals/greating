package com.codals.greating.diy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.user.dto.LoginRequestDto;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/mealdiy")
public class DiyController {

	@GetMapping
	public String loadMainPage() {
		return "diy/diy-main";
	}

	@GetMapping("/popular")
	public String loadTop10Page() {
		return "diy/diy-top10";
	}

	@GetMapping("/new")
	public String loadCreatePage() {
		return "diy/diy-create";
	}
	
	/*
	 * @PostMapping("/new") public void createNewPost(@SessionAttribute("loginUser")
	 * LoginRequestDto loginUser, @ModelAttribute("newPost") DiyRequestDto newPost)
	 * { log.info(loginUser); log.info(newPost); }
	 */


	@GetMapping("/{postId}")
	public String loadPostDetailPage(@PathVariable String postId) {
		return "diy/diy-detail";
	}
}
