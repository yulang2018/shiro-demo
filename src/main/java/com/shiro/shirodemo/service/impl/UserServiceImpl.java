package com.shiro.shirodemo.service.impl;

import com.shiro.shirodemo.mapper.UserMapper;
import com.shiro.shirodemo.model.User;
import com.shiro.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }
}
