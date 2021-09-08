package com.atguigu.spring5;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.Orders;
import com.atguigu.spring5.User;
import com.atguigu.spring5.bean.Emp;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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
        //创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_day01.xml");

        //获取配置创建的对象
        //创建对象时，默认也是执行无参构造方法完成对象创建
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
//        System.out.println(user.getUsername());
//
//        //p名称空间注入(底层：set方法注入)
//        User user1 = context.getBean("user1", User.class);
//        System.out.println(user1.getUsername());
    }

    @Test
    public void testBook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean_day01.xml");
        Book book=context.getBean("book", Book.class);
//        Book book = (Book) context.getBean("book");

//        Object[] args可以给bean的属性赋值，赋值的方式有两种：构造方法和工厂方法
//        通过这种方式获取的bean必须把scope属性设置为prototype，也就是非单例模式
//        Book book = (Book) context.getBean("book", new Book(""));

//        该类型的bean在IOC容器中也必须是唯一的
//        Book book = context.getBean(Book.class);
        book.testDemo();
        System.out.println(book.getBid());
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

        System.out.println("**************");

        Emp emp1=context.getBean("emp1", Emp.class);
        emp1.add();

        System.out.println("**************");

        Emp emp2=context.getBean("emp2", Emp.class);
        emp2.add();
    }



}
