package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.DepartmentMapper;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname MyBatisTest1
 * @Description TODO
 * @Date 8:36 2021/8/19
 * @Created by hejx
 */

public class MyBatisTest1 {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test05() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //1.获取到的SqlSession不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();

        EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);

        /*简单的封装*/
//        Employee empById = mapper.getEmpById(7);
//        System.out.println(empById);

        /*
        * 复杂封装
        *    1.利用级联属性
        *    2.利用<association/>
        *
        */
//        Employee employee = mapper.getEmpAndDept(7);
//        System.out.println(employee);

        /*分步查询*/
        /*Employee emp = mapper.getEmpByIdStep(7);
        System.out.println(emp.getDep().getDepartmentName());*/

//        Employee employee = mapper.getEmpByIdStep1(7);
//        System.out.println(employee);

        //2.手动提交数据
        openSession.commit();

        openSession.close();
    }

    @Test
    public void test06() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = openSession.getMapper(DepartmentMapper.class);

        /*<collection/>定义关联集合类型的属性的封装规则*/
        /*Department department = departmentMapper.getDeptByIdPlus(1);
        System.out.println(department);
        System.out.println(department.getEmployees());*/


        Department department = departmentMapper.getDeptByIdStep(2);
        System.out.println(department);
        System.out.println(department.getEmployees());


        openSession.commit();
        openSession.close();

    }

}
