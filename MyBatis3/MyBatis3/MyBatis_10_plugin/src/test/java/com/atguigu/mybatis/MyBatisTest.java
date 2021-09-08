package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname MyBatisTest
 * @Description TODO
 * @Date 10:05 2021/8/23
 * @Created by hejx
 */

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01() throws IOException {

        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        // 3、获取接口的实现类对象
        //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpById(1);
        System.out.println(mapper.getClass());
        System.out.println(employee);

        openSession.close();
    }


    /**
     * 插件原理
     * 在四大对象创建的时候
     * 1、每个创建出来的对象不是直接返回的，而是
     * 		interceptorChain.pluginAll(parameterHandler);
     * 2、获取到所有的Interceptor（拦截器）（插件需要实现的接口）；
     * 		调用interceptor.plugin(target);返回target包装后的对象
     * 3、插件机制，我们可以使用插件为目标对象创建一个代理对象；AOP（面向切面）
     * 		我们的插件可以为四大对象创建出代理对象；
     * 		代理对象就可以拦截到四大对象的每一个执行；
     *
     public Object pluginAll(Object target) {
     for (Interceptor interceptor : interceptors) {
     target = interceptor.plugin(target);
     }
     return target;
     }

     */
    /**
     * 插件编写：(P80 13:30)
     * 1、编写Interceptor的实现类
     * 2、使用@Intercepts注解完成插件签名
     * 3、将写好的插件注册到全局配置文件中
     *
     */
    public void testPlugin(){

    }

}
