package com.codals.greating.user.dao;

import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final SqlSession sqlSession;

    @Override
    public User selectByUsernameAndPassword(LoginRequestDto loginRequestDto) {
        return sqlSession.selectOne("user.selectByUsernameAndPassword", loginRequestDto);
    }

    @Override
    public User selectByUsername(String username) {
        return sqlSession.selectOne("user.selectByUsername", username);
    }

	@Override
	public int insertUser(User user) {
		String statement = "user.insertUser";
		return sqlSession.insert(statement, user);
	}

	@Override
	public User selectUserEmail(String email) {
		String statement = "user.selectUserEmail";
		return sqlSession.selectOne(statement, email);
	}
}
