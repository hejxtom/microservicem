package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 13:56 2021/8/12
 * @Created by hejx
 */

@Controller
public class TestController {

    @RequestMapping("/success")
    public String testSuccess(){
        return "succes";
    }
    
}
