package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 21:13 2021/3/30
 * @Created by hejx
 */
/**
 * propagation：事务传播行为
 * ioslation：事务隔离级别
 *
 *
 *
 */
@Service
@Transactional(readOnly = false,timeout = -1,propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)  //可以加到类上（若添加到方法上面，则类中所有方法加上注解），也可以添加到方法上
public class UserService {
    @Autowired
    private UserDao userDao;

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
