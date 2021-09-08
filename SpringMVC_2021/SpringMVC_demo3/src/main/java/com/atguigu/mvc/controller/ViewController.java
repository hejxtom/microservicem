package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ViewController
 * @Description TODO
 * @Date 16:06 2021/8/11
 * @Created by hejx
 */
@Controller
public class ViewController {

    @RequestMapping("/testView")
    public String testView(){
        return "test_view";
    }

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){

        return "redirect:/testThymeleafView";
    }

}
