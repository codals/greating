package com.codals.greating.constant;

import lombok.Getter;

@Getter
public enum SessionKey {

    LOGIN_USER("loginUser");

    private final String key;

    SessionKey(String key) {
        this.key = key;
    }
}
