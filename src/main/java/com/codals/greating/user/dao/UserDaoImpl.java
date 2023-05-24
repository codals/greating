package com.codals.greating.user.dao;

import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final SqlSession sqlSession;

    @Override
    public Optional<User> selectByUsernameAndPassword(LoginRequestDto loginRequestDto) {
        User user = sqlSession.selectOne("user.selectByUsernameAndPassword", loginRequestDto);
        return Optional.ofNullable(user);
    }
}
