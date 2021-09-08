package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 15:06 2021/8/9
 * @Created by hejx
 */
@Controller
public class TestController {


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //通过ServletAPI获取:不支持ant风格路径
    @RequestMapping("/testServletApi")
    public String testPath(HttpServletRequest request){
        //request:表示当前请求
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+","+password);
        return "test_param";
    }


}
