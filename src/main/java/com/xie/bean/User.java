package com.xie.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String pwd;

    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }


}
