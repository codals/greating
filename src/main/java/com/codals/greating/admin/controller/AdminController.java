package com.codals.greating.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codals.greating.admin.dto.AdminDto;
import com.codals.greating.admin.service.AdminService;
import com.codals.greating.user.entity.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService service;

	@GetMapping("/popular")
	public String loadAdminMainPage(@SessionAttribute("loginUser") User loginUser, Model model) {
		List<AdminDto> postList = service.topList();
		System.out.println(loginUser);
		model.addAttribute("list", postList);

		return "admin/admin-popularList";
	}
	
	@GetMapping("/register")
	public String adminRegister() {
		return "admin/admin-register";
	}
	
	@GetMapping("/commingsoon")
	public String loadAdminCommingSoon(Model model) {
		List<AdminDto> commingSoonList = service.commingSoonList();
		model.addAttribute("list", commingSoonList);
		return "admin/admin-commingsoon";
	}
	
	@GetMapping("/allList")
	public String loadAdminAllList(@SessionAttribute("loginUser") User loginUser, Model model) {
		List<AdminDto> allList = service.allList();

		model.addAttribute("list", allList);
		System.out.println(allList);

		return "admin/admin-allList";
	}
}
