package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author hejx
 * @createTime 2020/2/16 10:36
 * @description
 */
@RestController
public class DeptConsumerController {

//  private static final String REST_URL_PREFIX="http://localhost:8001";
    /**
     * 注册再EurekaServer中的微服务名称
     */
     private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add( DeptEntity deptEntity){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.postForObject(
                REST_URL_PREFIX+"/dept/add",
                deptEntity,
                Boolean.class);
    }

    @RequestMapping("/consumer/dept/findById/{deptNo}")
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/findById/"+deptNo,
                DeptEntity.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/consumer/dept/findAll")
    public List<DeptEntity> findAll(){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/findAll",
                List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/discovery",
                Object.class);
    }
}