package com.codals.greating.interceptor;

import static com.codals.greating.constant.SessionKey.LOGIN_USER;

import com.codals.greating.user.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 개발 편의를 위한 일시적인 설정
 */
@Log4j2
public class TemporaryUserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute(LOGIN_USER.getKey(), userService.getUserByUsername("user1"));
        return true;
    }
}
