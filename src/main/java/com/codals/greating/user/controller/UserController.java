package com.codals.greating.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

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
}
