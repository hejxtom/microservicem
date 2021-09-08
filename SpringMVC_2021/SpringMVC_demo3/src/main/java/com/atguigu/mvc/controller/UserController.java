package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 14:49 2021/8/12
 * @Created by hejx
 *
 *
 * 使用RESTFul模拟用户资源的增删改查
 * /user             GET        查询所有用户信息
 * /user/{id}        GET        根据id查询用户信息
 * /user             POST       添加用户信息
 * /user/{id}        DELETE     删除用户信息(RESTFul案例去体现)
 * /user             PUT        修改用户信息
 */
@Controller
public class UserController {


    @GetMapping("/testRest")
    public String testRest() {
        return "test_rest";
    }


    //    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    //    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("根据id=" + id + "，查询用户信息");
        return "success";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(@RequestParam String username, String password) {
        System.out.println("添加用户信息：username=" + username + ",password=" + password);
        return "success";
    }


/*    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        System.out.println("根据id=" + id + "，删除用户信息");
        return "success";
    }*/

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
//    @PutMapping("/user/")
    public String updateUserById(String username, String password) {
        System.out.println("修改用户信息：username=" + username + ",password=" + password);
        return "success";
    }
}
