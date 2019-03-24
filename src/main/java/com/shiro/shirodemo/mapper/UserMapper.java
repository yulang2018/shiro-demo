package com.shiro.shirodemo.mapper;

import com.shiro.shirodemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.concurrent.ScheduledFuture;

@Mapper
public interface UserMapper {
    User findUserByUserName(@Param("userName")String userName);
}
