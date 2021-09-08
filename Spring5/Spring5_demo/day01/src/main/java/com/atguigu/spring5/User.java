package com.atguigu.spring5;

/**
 * @Classname User
 * @Description TODO
 * @Date 14:15 2021/3/12
 * @Created by hejx
 */

public class User {

    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void add(){
        System.out.println("add.....");
    }

}