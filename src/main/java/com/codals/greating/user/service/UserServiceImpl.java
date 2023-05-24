package com.codals.greating.user.service;

import com.codals.greating.user.dao.UserDao;
import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public void login(LoginRequestDto loginRequestDto) {
        Optional<User> user = userDao.selectByUsernameAndPassword(loginRequestDto);
        if (!user.isPresent()) {
            throw new NullPointerException("User not found");
        }
    }
}
