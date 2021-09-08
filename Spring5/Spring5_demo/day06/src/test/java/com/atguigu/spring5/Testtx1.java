package com.atguigu.spring5;


import com.atguigu.spring5.xml.UserService1;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname Testtx1
 * @Description TODO
 * @Date 20:05 2021/3/31
 * @Created by hejx
 */

public class Testtx1 {
    @Test
    public void testAccount(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService1 userService = context.getBean("userService1", UserService1.class);
        userService.add();

    }
}
