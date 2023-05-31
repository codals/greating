package com.codals.greating.user.entity;

import com.codals.greating.date.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    private Integer id;
    private String username;
    private String name;
    private String password;
    private String email;
    private String birth;
    private String gender;
    private String phone;
    private String role;

    public User(Integer id,
                String username,
                String name,
                String password,
                String email,
                String birth,
                String gender,
                String phone,
                String role) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;
        this.role = role;
    }
}
