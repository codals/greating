package com.codals.greating.diy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


	@GetMapping("/{postId}")
	public String loadPostDetailPage(@PathVariable String postId) {
		return "diy/diy-detail";
	}
}
