package com.codals.greating.user.exception;

import com.codals.greating.exception.BusinessException;
import com.codals.greating.exception.ErrorCode;

public class AlreadyLoggedInException extends BusinessException {

    public AlreadyLoggedInException() {
        super(ErrorCode.INVALID_LOGIN_ACCESS);
    }
}
