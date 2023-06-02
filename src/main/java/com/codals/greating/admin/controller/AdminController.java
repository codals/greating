package com.codals.greating.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/popular")
	public String adminMain() {
		return "admin/admin-popularList";
	}
	
	@GetMapping("/register")
	public String adminRegister() {
		return "admin/admin-register";
	}
}
