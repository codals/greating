package com.codals.greating.user.dao;

import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.User;
import java.util.Optional;

public interface UserDao {

    Optional<User> selectByUsernameAndPassword(LoginRequestDto loginRequestDto);

    Optional<User> selectByUsername(String username);

	int insertUser(User user) throws Exception;

	User selectUserEmail(String email);

}
