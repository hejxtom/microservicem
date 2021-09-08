package com.atguigu.spring5.factorybean;

import com.atguigu.spring5.collectiontype.Couse;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Classname MyBean
 * @Description TODO
 * @Date 9:21 2021/3/17
 * @Created by hejx
 */
//工厂bean
public class MyBean implements FactoryBean<Couse> {
    //定义返回bean的对象
    @Override
    public Couse getObject() throws Exception {
        Couse Couse=new Couse();
        Couse.setCname("abc");
        return Couse;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
