package com.atguigu.spring5;

/**
 * @Classname Book
 * @Description TODO
 * @Date 20:02 2021/3/15
 * @Created by hejx
 */

public class Book {

   private String bname;

   private String avta;
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }


    public Book(String avta) {
        this.avta = avta;
    }

    public void testDemo(){

        System.out.println("使用set方法注入："+bname);
        System.out.println("使用有参构造方法注入："+avta);

    }
}
