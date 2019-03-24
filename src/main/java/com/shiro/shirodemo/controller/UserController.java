package com.shiro.shirodemo.controller;

import com.shiro.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Object user(){
        return userService.findByUserName("admin");
    }
}
