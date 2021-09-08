package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

/**
 * @Classname ParamController
 * @Description TODO
 * @Date 15:11 2021/8/10
 * @Created by hejx
 */

@Controller
public class ParamController {

    @RequestMapping("/testParam")
    //复选框/单选框类型的请求参数：String[]或String(多请求参数中出现多个同名的请求参数，可以在控制器方法的形参设置String[]或String来接收此参数)
    //若使用字符串类型则每个值使用逗号隔开，若使用字符串类型的数组，则装入数组中
    //@RequestParam:三个属性参见配套讲义(SpringMVC笔记.md),默认映射
    //@RequestHeader/@CookieValue:三个属性参见配套讲义(SpringMVC笔记.md),默认不映射
    public String testParam(
            @RequestParam(value = "user_name",required = false,defaultValue = "hhh") String username,
            @RequestParam Integer password,
            String hobby
            /*@RequestHeader(value = "Host") String host,
            @CookieValue("testcookie") String cookie*/){
        System.out.println("username:"+username+", password:"+password+", hobby:"+ hobby);
        /*System.out.println("Host:"+host);
        System.out.println("cookie:"+cookie);*/
        return "successe";
    }


    @RequestMapping("/testPojo")
    public String testPojo(User user){
        //User实体类中的属性名与请求参数名保持一致
        //形参只要满足条件就都会被赋值，不论一个或者两个

        //get请求乱码是tomcat造成的 -->conf/server.xml -->URIEncoding="UTF-8"
        //post请求，在web.xml中配置CharacterEncodingFilter
        System.out.println(user);
        return "successe";
    }




}
