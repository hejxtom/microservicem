package com.atguigu.spring5.aop1;

import org.springframework.stereotype.Component;

/**
 * @Classname User
 * @Description TODO
 * @Date 15:00 2021/3/29
 * @Created by hejx
 *
 * 被增强类
 */
@Component
public class User {

    public void add() {
        System.out.println("User...");

    }

}