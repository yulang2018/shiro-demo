package com.shiro.shirodemo.controller;

import com.shiro.shirodemo.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/loginUser")
    public String loginUser(String userName, String password, HttpSession session){
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userName,password);
        Subject subject= SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
        User user = (User) subject.getPrincipal();
        session.setAttribute("user",user);
        return "index";
    }



}
