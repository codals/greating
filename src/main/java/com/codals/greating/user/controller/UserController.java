package com.codals.greating.user.controller;

import static com.codals.greating.constant.SessionKey.LOGIN_USER;

import com.codals.greating.user.entity.Role;
import com.codals.greating.user.exception.AlreadyLoggedInException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codals.greating.user.entity.User;
import com.codals.greating.user.service.UserService;
import org.springframework.web.bind.annotation.SessionAttribute;

@Log4j2
@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
    @GetMapping("/login")
    public String loadLoginPage(@SessionAttribute(name = LOGIN_USER, required = false) User loginUser) {
        checkAlreadyLogin(loginUser);
        return "user/login";
    }

    @GetMapping("/register")
    public String loadRegisterPage(@SessionAttribute(name = LOGIN_USER, required = false) User loginUser) {
        checkAlreadyLogin(loginUser);
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

    private void checkAlreadyLogin(User loginUser) {
        if (loginUser != null) {
            throw new AlreadyLoggedInException();
        }
    }
}
