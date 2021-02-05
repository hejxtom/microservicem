package com.atguigu.gmall.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 * 
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 * @author lfy
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

//	@Autowired
//	@Reference(loadbalance="random",timeout=3000) //dubbo直连
//	@Reference(url = "192.168.184.128:20880")
	@Reference
	UserService userService;
	
	@HystrixCommand(fallbackMethod="hello")
	@Override
	public List<UserAddress> initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		return addressList;
	}

	public List<UserAddress> hello(String userId) {
		System.out.println("测试用户id："+userId+"......Hystrix");

		return Arrays.asList(new UserAddress(1, "测试地址", "1", "测试", "测试", "C"));
	}

}
