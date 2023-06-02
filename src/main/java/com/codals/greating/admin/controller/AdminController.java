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
//		model.addAttribute("dto", dto);
		model.addAttribute("list", postList);
//		System.out.println(dto + "," + postList);
		return "admin/admin-popularList";
	}
}
