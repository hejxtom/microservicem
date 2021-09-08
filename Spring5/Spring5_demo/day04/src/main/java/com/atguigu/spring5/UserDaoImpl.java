package com.atguigu.spring5;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Date 10:17 2021/3/24
 * @Created by hejx
 */

public class UserDaoImpl implements UserDao {


    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
