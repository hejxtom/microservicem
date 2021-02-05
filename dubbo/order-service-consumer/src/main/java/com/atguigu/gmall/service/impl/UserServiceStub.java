package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.util.StringUtils;


import java.util.List;

public class UserServiceStub implements UserService {

    private  final  UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    public List<UserAddress> getUserAddressList(String userId) {

        System.out.println("com.atguigu.gmall.service.impl.UserServiceStub");

        if(!StringUtils.isEmpty(userId))  return userService.getUserAddressList(userId);
        return null;
    }
}
