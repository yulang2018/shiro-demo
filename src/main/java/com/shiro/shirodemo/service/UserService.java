package com.shiro.shirodemo.service;

import com.shiro.shirodemo.model.User;

public interface UserService {
    User findByUserName(String userName);
}
