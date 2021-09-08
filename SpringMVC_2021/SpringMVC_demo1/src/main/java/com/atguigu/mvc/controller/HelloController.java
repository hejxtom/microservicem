package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 16:31 2021/8/8
 * @Created by hejx
 */


@Controller
public class HelloController {

//    "/" --->/WEB-INF/templates/index.html
    @RequestMapping("/")
    public String index() {
        //返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        //返回视图名称
        return "target";
    }

}
