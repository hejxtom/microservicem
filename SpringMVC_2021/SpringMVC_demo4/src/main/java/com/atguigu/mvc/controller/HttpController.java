package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname HttpController
 * @Description TODO
 * @Date 14:57 2021/8/14
 * @Created by hejx
 */
@Controller
public class HttpController {

    @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println(requestBody); //username=admin&password=123
        return "success";
    }


    @RequestMapping(value = "/testRequestEntity",method = RequestMethod.POST)
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //获取请求头
        System.out.println(requestEntity.getHeaders());
        //获取请求体
        System.out.println(requestEntity.getBody());
        return "success";
    }


    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello,response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }


    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1,"admin","123",22,"男");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println(username+","+password);
        return "hello,axios";
    }

}
