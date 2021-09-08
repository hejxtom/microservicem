package com.atguigu.spring5.testDemo;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.Orders;
import com.atguigu.spring5.User;
import com.atguigu.spring5.bean.Emp;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname TestSpring5
 * @Description TODO
 * @Date 14:19 2021/3/12
 * @Created by hejx
 */

public class TestSpring5 {

    @Test
    public void testUser(){
        //加载spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_day01.xml");

        //获取配置创建的对象
        //创建对象时，默认也是执行无参构造方法完成对象创建
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
        System.out.println(user.getUsername());

        User user1 = context.getBean("user1", User.class);
        System.out.println(user1.getUsername());
    }

    @Test
    public void testBook(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean_day01.xml");
        Book book=context.getBean("book", Book.class);

        book.testDemo();
    }

    @Test
    public void testOrders(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean_day01.xml");
        Orders order=context.getBean("order", Orders.class);

        order.testDemo();
    }

    @Test
    public void testService(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean_day01.xml");
        UserService userService=context.getBean("userService", UserService.class);

        userService.add();
    }

    @Test
    public void testEmpt(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean_day01.xml");
        Emp emp=context.getBean("emp", Emp.class);
        emp.add();

        Emp emp1=context.getBean("emp1", Emp.class);
        emp1.add();

        Emp emp2=context.getBean("emp2", Emp.class);
        emp2.add();
    }



}
