package com.atguigu.spring5.dao.Impl;

import com.atguigu.spring5.dao.UserDAO;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDAOImpl
 * @Description TODO
 * @Date 9:12 2021/3/24
 * @Created by hejx
 */

@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {
    @Override
    public void add() {
        System.out.println("dao add...");
    }
}
