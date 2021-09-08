package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Classname ScopController
 * @Description TODO
 * @Date 17:42 2021/8/10
 * @Created by hejx
 */

@Controller
public class ScopController {
//     利用 <mvc:view-controller path="/" view-name="index"/>配置
//    @RequestMapping("/")
//    public String test(){
//        return "index";
//    }


    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestSocpe", "hello,servletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        //1.创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2.处理模型数据,即向请求域request共享数据
        modelAndView.addObject("testRequestSocpe","hello,ModelAndView");
        //3.设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestSocpe","hello,Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestSocpe","hello,Map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestSocpe","hello,ModelMap");
        //Model、ModelMap、Map类型的参数的区别：参见BindingAwareModelMap源码
//        System.out.println(modelMap.getClass().getName());  //org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionSocpe","hello,HttpSession");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){

        ServletContext application = session.getServletContext();
        application.setAttribute("testApplication","hello,application");

        return "success";
    }

}
