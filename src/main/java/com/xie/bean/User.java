package com.xie.bean;

import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private String pwd;

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }


}
