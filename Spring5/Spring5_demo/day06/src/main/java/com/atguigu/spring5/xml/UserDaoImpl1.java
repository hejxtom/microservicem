package com.atguigu.spring5.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Date 21:14 2021/3/30
 * @Created by hejx
 */
@Repository
public class UserDaoImpl1 implements UserDao1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addMoney() {
        jdbcTemplate.update("update t_account set money=money-? where username=?",100,"lucy");
    }

    @Override
    public void reduceMoney() {
        jdbcTemplate.update("update t_account set money=money+? where username=?",100,"mary");
    }
}
