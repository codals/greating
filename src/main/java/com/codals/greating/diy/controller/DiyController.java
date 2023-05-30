package com.codals.greating.diy.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.service.DiyService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/mealdiy")
@RequiredArgsConstructor
public class DiyController {
	
	Logger log = LogManager.getLogger("case3");


	private final DiyService diyService;
	
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


	@GetMapping("/{postId}")
	public String loadPostDetailPage(@PathVariable int postId, Model model) {
		log.debug("start post detail ");
		
		PostResponseDto postDetail = diyService.getPostDetail(postId);
		model.addAttribute("postDetail", postDetail);
		
		return "diy/diy-detail";
	}
}
