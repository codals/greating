package com.codals.greating.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.codals.greating.user.dao.UserDao;
import com.codals.greating.user.dto.LoginRequestDto;
import com.codals.greating.user.entity.Role;
import com.codals.greating.user.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserDao userDao;

    private User user;

    @Before
    public void setup() {
        user = new User(1, "user1", "홍길동", "password123",
            "john.doe@example.com", "1990-01-01", "Male", "1234567890", Role.USER);
    }

    @Test
    public void 사용자가_인증에_성공한다() {
        // given
        when(userDao.selectByUsernameAndPassword(Mockito.any(LoginRequestDto.class)))
            .thenReturn(user);

        // when
        boolean result = userServiceImpl.authenticate(new LoginRequestDto("홍길동", "password123"));

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void 사용자가_인증에_실패한다() {
        // given
        when(userDao.selectByUsernameAndPassword(Mockito.any(LoginRequestDto.class)))
            .thenReturn(null);

        // when
        boolean result = userServiceImpl.authenticate(new LoginRequestDto("홍길동", "password123"));

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void 유효한_사용자를_조회한다() {
        // given
        String username = "user1";
        when(userDao.selectByUsername(username)).thenReturn(user);

        // when
        User resultUser = userServiceImpl.getUserByUsername(username);

        // then
        assertNotNull(resultUser);
        assertEquals(user.getId(), resultUser.getId());
        assertEquals(user.getUsername(), resultUser.getUsername());
        assertEquals(user.getName(), resultUser.getName());
    }

    @Test
    public void 존재하지_않는_사용자를_조회한다() {
        // given
        String username = "nonexistent";
        when(userDao.selectByUsername(username)).thenReturn(null);

        // when
        User resultUser = userServiceImpl.getUserByUsername(username);

        // then
        assertNotNull(resultUser);
        verify(userDao, times(1)).selectByUsername(username);
    }
}
