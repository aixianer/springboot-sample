package com.xie.converter;

import com.xie.bean.User;
import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, User> {

    @Override
    public User convert(String source) {
        System.out.println(source);
        return new User("bbbbbbbb","bbbbbbbb");
    }
}
