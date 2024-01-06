package com.xie.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    private long id;
    @NotNull(message = "名字不能为空")
    private String name;
    private String pwd;

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }


}
