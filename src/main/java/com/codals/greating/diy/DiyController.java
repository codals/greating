package com.codals.greating.diy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/diy")
public class DiyController {

	@GetMapping
	public String goToMain() {
		return "diy/diy-main";
	}
	
	@GetMapping("/detail")
	public String goToDetail() {
		return "diy/diy-detail";
	}
	
}
