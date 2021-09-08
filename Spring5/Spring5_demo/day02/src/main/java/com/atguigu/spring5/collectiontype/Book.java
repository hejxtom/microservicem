package com.atguigu.spring5.collectiontype;

import java.util.List;

/**
 * @Classname Book
 * @Description TODO
 * @Date 8:49 2021/3/17
 * @Created by hejx
 */

public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test(){
        System.out.println(list);
    }

}
