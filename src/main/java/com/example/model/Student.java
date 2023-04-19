package com.example.model;

import lombok.Data;

@Data
public class Student {
    private Long id;

    private String userName;

    private String passWord;

    private String email;

    private String nickName;

    private String regTime;
}
