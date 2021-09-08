package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 20:50 2021/3/15
 * @Created by hejx
 */

public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        userDao.update();
        System.out.println("service....");
    }
}
