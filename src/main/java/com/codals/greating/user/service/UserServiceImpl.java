package com.codals.greating.user.service;

import com.codals.greating.user.dao.UserDao;
import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public boolean authenticate(LoginRequestDto loginRequestDto) {
        User user = userDao.selectByUsernameAndPassword(loginRequestDto); // 에러 논의 필요
        return user.getId() != null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Transactional
	@Override
	public boolean register(User user) {

    	try {
			if(userDao.insertUser(user) ==1 ) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkUserEmail(String email) {
        if(userDao.selectUserEmail(email)==null) {
        	return true;
        }
        return false;

	}


}
