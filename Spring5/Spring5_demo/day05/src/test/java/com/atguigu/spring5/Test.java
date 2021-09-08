package com.atguigu.spring5;

import com.atguigu.spring5.entiy.User;
import com.atguigu.spring5.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * @Classname Test
 * @Description TODO
 * @Date 19:27 2021/3/29
 * @Created by hejx
 */

public class Test {

    @org.junit.Test
    public void testJdbcTemplate(){
        User user=new User();
        user.setId(4);
        user.setUsername("hejx");
        user.setPassword("123456");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addUser(user);
    }

    @org.junit.Test
    public void testJdbcTemplate1(){
        User user=new User();
        user.setId(4);
        user.setUsername("hejx");
        user.setPassword("12345678");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.updateUser(user);
    }

    @org.junit.Test
    public void testJdbcTemplate2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteUser(1);
    }


    @org.junit.Test
    public void testJdbcTemplate3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.selectCount());

        System.out.println(bookService.selectUser(2));

        System.out.println(bookService.selectUsers());


    }

    @org.junit.Test
    public void testBatchAdd(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Object[] o1={11,"111","111"};
        Object[] o2={12,"222","222"};
        Object[] o3={13,"333","333"};

        ArrayList<Object[]> users1 = new ArrayList<>();

        users1.add(o1);
        users1.add(o2);
        users1.add(o3);
        bookService.batchAdd(users1);

    }

    @org.junit.Test
    public void testBatchUpdate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Object[] o1={"1112","1112",11};
        Object[] o2={"2223","2223",12};
        Object[] o3={"3334","3334",13};

        ArrayList<Object[]> users1 = new ArrayList<>();

        users1.add(o1);
        users1.add(o2);
        users1.add(o3);
        bookService.batchupdate(users1);

    }


    @org.junit.Test
    public void testBatchDelete(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Object[] o1={11};
        Object[] o2={12};
        Object[] o3={13};

        ArrayList<Object[]> users1 = new ArrayList<>();

        users1.add(o1);
        users1.add(o2);
        users1.add(o3);
        bookService.batchdelete(users1);

    }
}
