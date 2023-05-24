package com.codals.greating.user.entity;

import com.codals.greating.date.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User extends BaseEntity {

    private Long id;
    private String username;
    private String name;
    private String password;
    private String email;
    private String birth;
    private String gender;
    private String phone;
    private String role;
}
