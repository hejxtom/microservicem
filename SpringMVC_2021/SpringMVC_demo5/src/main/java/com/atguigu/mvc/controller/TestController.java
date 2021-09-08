package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 10:54 2021/8/15
 * @Created by hejx
 */

@Controller
public class TestController {


    @RequestMapping("/testInterceptor")
    public String testInterceptor(){

        return "success";
    }


    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler(){
        System.out.println(1/0);
        return "success";
    }

}
