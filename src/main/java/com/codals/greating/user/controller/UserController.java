package com.codals.greating.user.controller;

import com.codals.greating.user.entity.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codals.greating.user.entity.User;
import com.codals.greating.user.service.UserService;

@Log4j2
@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
    @GetMapping("/login")
    public String loadLoginPage() {
        return "user/login";
    }

    @GetMapping("/register")
    public String loadRegisterPage() {
        return "user/register";
    }

    @GetMapping("/register-agreement")
    public String loadRegisterAgreementPage() {
        return "user/register-agreement";
    }

    @GetMapping("/register-form")
    public String loadRegisterFormPage() {
        return "user/register-form";
    }
    
    @PostMapping("/register")
    public String register(User user) {
       
    	user.setRole(Role.USER);
    	if(userService.register(user)) {
    		return "/user/login";
    	};
    	
        return "redirect:/";
    }
}
