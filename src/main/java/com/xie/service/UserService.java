package com.xie.service;

import com.xie.bean.User;
import com.xie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public boolean addUser(String userName, String pwd) {
        return userMapper.insert(userName, pwd) > 0 ? true : false;
    }

    public User getUserByName(String userName) {
        return userMapper.findByName(userName);
    }
}
