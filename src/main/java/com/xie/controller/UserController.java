package com.xie.controller;

import com.xie.bean.User;
import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,headers = "Content-Length1")
    public User addUser(@RequestBody User user) {
        String str = userService.addUser(user.getName(), user.getPwd()) ? "success" : "fail";
        return new User("aaa","bbb");
    }


    @RequestMapping(path = "/add1/{name}/{pwd}")
    @Transactional
    public String addUser1(@PathVariable String name, @PathVariable String pwd) {
        return userService.addUser(name, pwd) ? "success" : "fail";
    }

    @RequestMapping(path = "/add2")
    @Transactional
    public String addUser2(@RequestParam String name, @RequestParam String pwd) {
        return userService.addUser(name, pwd) ? "success" : "fail";
    }


    @RequestMapping("/get")
    public User getUserByName(String userName) {
        return userService.getUserByName(userName);
    }

}
