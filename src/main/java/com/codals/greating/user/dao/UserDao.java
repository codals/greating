package com.codals.greating.user.dao;

import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.User;

public interface UserDao {

    User selectByUsernameAndPassword(LoginRequestDto loginRequestDto);

    User selectByUsername(String username);

	int insertUser(User user) throws Exception;

	User selectUserEmail(String email);

}
