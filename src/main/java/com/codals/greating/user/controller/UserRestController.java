package com.codals.greating.user.controller;

import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.User;
import com.codals.greating.user.service.UserService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession httpSession) {
        boolean isAuthenticated = userService.authenticate(loginRequestDto);
        if (isAuthenticated) {
            User user = userService.getUserByUsername(loginRequestDto.getUsername());
            httpSession.setAttribute("loginUser", user);
        }
        return ResponseEntity.ok(isAuthenticated);
    }
}
