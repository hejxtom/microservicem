package com.atguigu.spring5.xml;

import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 21:13 2021/3/30
 * @Created by hejx
 */
@Service(value = "userService1")
public class UserService1 {
    @Autowired
    private UserDao1 userDao;

    public void add() {
       // try {
            //1.开启事务

            //2.业务操作
            userDao.addMoney();

            //模拟异常
            int i = 10 / 0;


            userDao.reduceMoney();

            //3.没有发生异常，提交事务
       // } catch (Exception e) {
           //4.出现异常，事务回滚
       // }


    }

}
