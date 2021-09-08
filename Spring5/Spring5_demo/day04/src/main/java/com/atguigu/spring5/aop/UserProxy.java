package com.atguigu.spring5.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Classname UserProxy
 * @Description TODO
 * @Date 15:01 2021/3/29
 * @Created by hejx
 *
 * 增强类
 */
@Component
@Aspect //aop操作
@Order(value = 1) //设置增强类的优先级
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.atguigu.spring5.aop.User.add(..))")
    public void pointcutpdemo() {

    }

    //前置通知
    @Before(value = "pointcutpdemo()")
    public void before() {
        System.out.println("UserProxy...before...");
    }
    //最终通知
    @After(value = "execution(* com.atguigu.spring5.aop.User.add(..))")
    public void after() {
        System.out.println("after...");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.atguigu.spring5.aop.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "execution(* com.atguigu.spring5.aop.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    //环绕通知
    @Around(value = "pointcutpdemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前...");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后...");
    }
}
