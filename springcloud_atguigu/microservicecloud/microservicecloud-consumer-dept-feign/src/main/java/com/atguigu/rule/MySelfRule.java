package com.atguigu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hejx
 * @createTime 2020/2/16 10:34
 * @description
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //指定LoadBalanced的算法 用我们自定义的规则算法
        return new MyRandomRule();
//        return  new RandomRule();

    }

}