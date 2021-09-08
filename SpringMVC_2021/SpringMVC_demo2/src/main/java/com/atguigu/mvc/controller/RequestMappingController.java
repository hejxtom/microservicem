package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname RequestMappingController
 * @Description TODO
 * @Date 15:15 2021/8/9
 * @Created by hejx
 */
@Controller
//@RequestMapping("/hello")   //设置成/hello/testRequestMapping
public class RequestMappingController {


    /**
     *  value:满足value对应的String[]任意值都会发生映射，必填！
     *  method：满足method对应的RequestMethod[]任意值都会发生映射,默认是任何请求都可以接收(不以请求方式为映射条件)，非必填！
     *  params:满足method对应的String[]的全部值才会发生映射，非必填
     *          params = {"username"}:此映射请求需要包含username属性
     *          params = {"!username"}:此映射请求不存在username属性
     *          params = {"username=admin"}:此映射请求不存在username属性一定为admin
     *          params = {"username!=admin"}:此映射请求不存在username属性不等于admin
     *
     * headers:满足headers对应的String[]的全部值才会发生映射，非必填
     *
     * 请求映射顺序：
     *  value->method/params/headers
     */
    @RequestMapping(
            value = {"/testRequestMapping","/test"},
            method = {RequestMethod.GET,RequestMethod.POST}

    )
    public String successe(){
        return "successe";
    }

    @RequestMapping(
            value = {"/testParams","/test"}, //匹配不成功：404
            method = {RequestMethod.GET,RequestMethod.POST},  //匹配不成功：405
            params = {"username"}, //匹配不成功：400
            headers = {"Host=localhost:8080"} //匹配不成功：404
    )
    public String testParams(){
        return "successe";
    }


    //@GetMapping/@PostMapping不需要设置method
    //目前浏览器只能发送：get与post,不能发送PUT、DELETE等，即使form表单的method=“put”,也按照get(默认)发送
    @GetMapping("/getMapping")
    public String testGetMapping(){
        return "successe";
    }

    @PostMapping("/postMapping")
    public String testPostMapping(){
        return "successe";
    }


    /**
     * ?:匹配一个任意字符(除[?\/])
     * *:匹配0~n个任意字符
     * **：表示任意的0~n层目录(注意：是目录)
     *
     */

//    @RequestMapping("/a?a/testAnt")
//    @RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt(){
        return "successe";
    }


    //testPath/{id}/{username}:请求路径必须按此格式，形参使用@PathVariable修饰，所以只能响应get
    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id") String id,@PathVariable("username") String username){
        System.out.println("id:"+id+","+"username:"+username);
        return "successe";
    }

}
