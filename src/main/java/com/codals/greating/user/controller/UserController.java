package com.codals.greating.user.controller;

import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String loadLoginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequestDto loginRequestDto) {
        try {
            userService.login(loginRequestDto);
        } catch (NullPointerException e) {
            return "error"; // 에러 페이지
        }
        return "home";
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
    public String register() {
        /**
         * 회원가입
         */
        return "redirect:/";
    }
}
