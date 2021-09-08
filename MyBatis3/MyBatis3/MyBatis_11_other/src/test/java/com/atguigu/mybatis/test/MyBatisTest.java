package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname MyBatisTest
 * @Description TODO
 * @Date 8:25 2021/8/17
 * @Created by hejx
 *
 */

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void test01() throws IOException {

        //1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();

        //2. 获取SqlSession实例,能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

        //第一种：
        Page<Object> page = PageHelper.startPage(5, 5);


        List<Employee> emps = mapper.getEmps();

        //第二种：
//        PageInfo<Employee> pageInfo = new PageInfo<>(emps);

        PageInfo<Employee> pageInfo = new PageInfo<>(emps,6);

        for (Employee emp: emps) {
            System.out.println(emp);
        }

       /* System.out.println("当前页码："+page.getPageNum());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("每页记录数"+page.getPageSize());*/

        System.out.println("当前页码："+pageInfo.getPageNum());
        System.out.println("总记录数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("每页记录数"+pageInfo.getPageSize());

        int[] nums = pageInfo.getNavigatepageNums();
        System.out.println(Arrays.toString(nums));


        openSession.close();
    }


    /**
     * Spring整合：applicationContext.xml
     *   <!--
     *      配置一个可以执行批量的sqlSession
     *      在service层：
     *              @Autowired
     *              private SqlSession sqlSession;//此sqlSession是一个批量的sqlSession
     *      -->
     *     <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
     *         <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactoryBean"></constructor-arg>
     *         <constructor-arg name="executorType" value="BATCH"></constructor-arg>
     *     </bean>
     *
     *
     */
    //批量操作
    @Test
    public void testBatch() throws IOException {

        //1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();

        //2. 获取SqlSession实例,能直接执行已经映射的sql语句
        //2.1 可以执行批量操作的sqlSession
        SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

        mapper.addEmps(new Employee(1,"olyi","olyi@test.com","男"));
        mapper.addEmps(new Employee(1,"olyi2","olyi@test.com","女"));
        mapper.addEmps(new Employee(1,"olyi3","olyi@test.com","男"));
        mapper.addEmps(new Employee(1,"olyi4","olyi@test.com","男"));

        openSession.commit();
        openSession.close();
    }

}
