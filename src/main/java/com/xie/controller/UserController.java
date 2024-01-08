package com.xie.controller;

import com.xie.bean.User;
import com.xie.learn.exception.FormValidationException;
import com.xie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User addUser(@RequestBody User user) {
        String str = userService.addUser(user.getName(), user.getPwd()) ? "success" : "fail";
        return new User("aaa","bbb");
    }
    @PostMapping(path = "/add1", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public User addUser1(@Valid @RequestBody User user, BindingResult result) {
        log.info("addUser1 start");
        if (result.hasErrors()) {
            log.warn("Binding Errors: {}", result);
            throw new ValidationException(result.toString());
        }

        String str = userService.addUser(user.getName(), user.getPwd()) ? "success" : "fail";
        log.info("addUser1 end");
        return new User("aaa","bbb");
    }



    @PostMapping(path = "/add2", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public User addUser2(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            log.warn("Binding Errors: {}", result);
            throw new FormValidationException(result);
        }

        String str = userService.addUser(user.getName(), user.getPwd()) ? "success" : "fail";
        return new User("aaa","bbb");
    }
/*

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> validationExceptionHandler(ValidationException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("message", exception.getMessage());
        return map;
    }
*/


//
//
//    @RequestMapping(path = "/add1/{name}/{pwd}")
//    @Transactional
//    public String addUser1(@PathVariable String name, @PathVariable String pwd) {
//        return userService.addUser(name, pwd) ? "success" : "fail";
//    }
//
//    @RequestMapping(path = "/add2")
//    @Transactional
//    public String addUser2(@RequestParam String name, @RequestParam String pwd) {
//        return userService.addUser(name, pwd) ? "success" : "fail";
//    }
//
//
//    @RequestMapping("/get")
//    public User getUserByName(String userName) {
//        return userService.getUserByName(userName);
//    }

}
