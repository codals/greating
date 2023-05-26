package com.codals.greating.diy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mealdiy")
public class DiyController {

	@GetMapping
	public String loadMain() {
		return "diy/diy-main";
	}

	@PostMapping
	public String search() {
		/**
		 * diy 메인 > 돋보기, 선택완료 버튼 (Ajax)
		 */
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

	@PostMapping("/new")
	public String create() {
		/**
		 * DIY 식단 저장, 상세보기 리다이렉트 (Ajax)
		 */
		return "redirect:/mealdiy/" + "1";
	}

	@GetMapping("/{postId}")
	public String loadPostDetailPage(@PathVariable String postId) {
		/**
		 * diy/diy-detail 예정
		 */
		return "diy/diy-detail";
	}
}
