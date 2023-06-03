package com.codals.greating.user.service;

import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.User;

public interface UserService {

    boolean authenticate(LoginRequestDto loginRequestDto);

    User getUserByUsername(String username);

	boolean register(User user);
}
