package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 19:44 2021/3/23
 * @Created by hejx
 */

//在注解里面value属性值可以省略不写
//默认是类名称，首字母小写
//@Component(value = "userService") //<bean id="" class=""/> 等价
@Service
public class UserService {
    //定义属性
    //不需要添加set方法
    //添加注入属性注解
//    @Autowired  //根据类型装配
//    @Qualifier(value = "userDAO" )  //根据名称装配，要和@Autowired进行使用(注意：用此注解value属性值不可省略，UserDAOImpl：@Repository注解value属性不可省略.且两处名字一致)
//    private UserDAO userDAO;

    @Resource  //既可以根据类型注入，还可以根据名称注入
    private UserDAO userDAO;

    @Value(value = "tom") //注入普通类型属性值
    private String name;
    public void add() {
        userDAO.add();
        System.out.println("userService.....,name:"+name);
    }

}
