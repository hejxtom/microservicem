package com.atguigu.spring5;

import com.atguigu.spring5.annotation.config.SpringConfig;
import com.atguigu.spring5.service.UserService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname testService
 * @Description TODO
 * @Date 19:48 2021/3/23
 * @Created by hejx
 */

public class testService {

    @Test
    public void testService(){
        ApplicationContext axc=new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = axc.getBean("userService", UserService.class);
        //System.out.println(userService);
        userService.add();
    }

    @Test
    public void testService2(){
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = acc.getBean("userService", UserService.class);
        //System.out.println(userService);
        userService.add();
    }

}
