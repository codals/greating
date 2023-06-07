package com.codals.greating.user.controller;

import static com.codals.greating.constant.SessionKey.LOGIN_USER;

import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.Role;
import com.codals.greating.user.entity.User;
import com.codals.greating.user.service.UserService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
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
            httpSession.setAttribute(LOGIN_USER, user);
        }
        return ResponseEntity.ok(isAuthenticated);
    }

  
    @GetMapping("/check-username")
    public ResponseEntity<Boolean> checkUserName(String username) {
    	if(userService.getUserByUsername(username) == null) {
    		return ResponseEntity.ok(true);
    	}
    	return ResponseEntity.ok(false);

    }
    
    
    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkUserEmail(String email) {
      
    	if(userService.checkUserEmail(email)) {
    		return ResponseEntity.ok(true);     
    	}
       	return ResponseEntity.ok(false);

    }
    
    @PostMapping("/register")
    public ResponseEntity<Boolean> register(User user) {
    	user.setRole(Role.USER);
    	if(userService.register(user)) {
    		return ResponseEntity.ok(true);     
    	}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }
}
