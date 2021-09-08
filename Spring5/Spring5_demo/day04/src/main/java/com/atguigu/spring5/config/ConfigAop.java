package com.atguigu.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Classname ConfigAop
 * @Description TODO
 * @Date 15:59 2021/3/29
 * @Created by hejx
 */
@Configuration
@ComponentScan(basePackages = {"com.atguigu.spring5.aop"})
@EnableAspectJAutoProxy(proxyTargetClass = true) //对应：<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class ConfigAop {
}
