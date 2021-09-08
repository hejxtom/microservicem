package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 19:20 2021/8/15
 * @Created by hejx
 */
@Controller
public class TestController {

    /*@RequestMapping("/")
    public String index(){
        return "index" ;
    }*/

    @RequestMapping("/testException")
    public String testException(){
        System.out.println(1/0);
        return "success";
    }

}
