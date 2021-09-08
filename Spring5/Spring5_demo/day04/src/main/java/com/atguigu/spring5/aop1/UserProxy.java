package com.atguigu.spring5.aop1;


import org.springframework.stereotype.Component;

/**
 * @Classname UserProxy
 * @Description TODO
 * @Date 15:46 2021/3/29
 * @Created by hejx
 */
@Component
public class UserProxy {

    public void before() {

        System.out.println("UserProxy...before...");
    }
}
