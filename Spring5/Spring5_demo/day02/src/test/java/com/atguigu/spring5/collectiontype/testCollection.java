package com.atguigu.spring5.collectiontype;

import com.atguigu.spring5.autowire.Emp;
import com.atguigu.spring5.bean.Orders;
import com.atguigu.spring5.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname testCollection
 * @Description TODO
 * @Date 21:46 2021/3/16
 * @Created by hejx
 */

public class testCollection {

    @Test
    public void testCollection(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        Student student=context.getBean("student",Student.class);
        System.out.println(student);
    }

    @Test
    public void testBook(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Book book=context.getBean("book",Book.class);
       book.test();
       //验证bean的作用域为单实例(Spring的bean默认是一个单实例对象)
        Book book1=context.getBean("book",Book.class);
        System.out.println(book == book1);
    }

    @Test
    public void testMyBean(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        Couse Couse=context.getBean("myBean", Couse.class);
        System.out.println(Couse);
        //book.test();
    }

    @Test
    public void testIsSingleton(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        Book Book=context.getBean("book", Book.class);
        Book Book1=context.getBean("book", Book.class);
        System.out.println(Book==Book1);
        //book.test();
    }

    @Test
    public void testBean(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean3.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取bean的对象:"+orders);

        //手动让bean实例销毁
        context.close();
    }

    @Test
    public void testEmp(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean4.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }


}
