package com.codals.greating.interceptor;

import static com.codals.greating.constant.SessionKey.LOGIN_USER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Log4j2
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute(LOGIN_USER) == null) {
            log.info("Unauthorized access detected. Request URI: {}", requestURI);
            response.sendRedirect("/greating/login?redirectURL=" + requestURI);
            return false;
        }
        return true;
    }
}
