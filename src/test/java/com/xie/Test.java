package com.xie;

import com.xie.bean.User;
import com.xie.utils.ValidatorUtil;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        User user = new User();
        List<String> valid = ValidatorUtil.valid(user);
        System.out.println(valid);
    }
}
