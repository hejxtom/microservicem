package com.atguigu.spring5.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Classname PersonProxy
 * @Description TODO
 * @Date 15:39 2021/3/29
 * @Created by hejx
 */
@Component
@Aspect
@Order(value = 3)
public class PersonProxy {

    //前置通知
    @Before(value = "execution(* com.atguigu.spring5.aop.User.add(..))")
    public void before() {
        System.out.println("PersonProxy....before...");
    }

}
