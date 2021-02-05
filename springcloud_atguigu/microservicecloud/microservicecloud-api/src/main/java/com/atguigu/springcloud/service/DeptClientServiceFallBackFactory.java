package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.DeptEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author GongXings
 * @createTime 31 14:52
 * @description 统一处理DeptClientService这个类中的熔断，主业务与熔断方法解耦
 */
//@Component 不要忘记添加，不要忘记添加
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

    //统一对我们的接口DeptClientService处理熔断
    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {

            @Override
            public boolean add(DeptEntity deptEntity) {
                return false;
            }

            @Override
            public DeptEntity findById(Long deptNo) {
                return new DeptEntity().setDeptNo(deptNo)
                        .setDeptName("该："+deptNo+"没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
                        .setDbSource("没有这个数据库");
            }

            @Override
            public List<DeptEntity> findAll() {
                return null;
            }
        };
    }
}