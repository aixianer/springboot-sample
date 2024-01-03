package com.xie.controller;

import com.xie.bean.User;
import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user1")
public class UserController1 {

    @Autowired
    private UserService userService;


    @RequestMapping("/add1")
    @Transactional
    public String addUser(@PathVariable String name, @PathVariable String pwd) {
        return userService.addUser(name, pwd) ? "success" : "fail";
    }

    @RequestMapping("/add")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user.getName(), user.getPwd()) ? "success" : "fail";
    }

    @RequestMapping("/get")
    public User getUserByName(String userName) {
        return userService.getUserByName(userName);
    }

}
