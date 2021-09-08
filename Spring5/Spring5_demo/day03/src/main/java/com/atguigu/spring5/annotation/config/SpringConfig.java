package com.atguigu.spring5.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname SpringConfig
 * @Description TODO
 * @Date 9:32 2021/3/24
 * @Created by hejx
 *
 * 完全注解开发
 */
@Configuration //作为配置类，替代配置文件
@ComponentScan(basePackages = {"com.atguigu.spring5"})
public class SpringConfig {



}
