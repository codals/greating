package com.codals.greating.user.service;

import com.codals.greating.user.dto.LoginRequestDto;

public interface UserService {

    void login(LoginRequestDto loginRequestDto);
}
