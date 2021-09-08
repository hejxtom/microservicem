package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname MyBatisTest
 * @Description TODO
 * @Date 16:46 2021/8/19
 * @Created by hejx
 */

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01(){
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession openSession=null;
        try {
            sqlSessionFactory = getSqlSessionFactory();

            openSession = sqlSessionFactory.openSession();

            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

            Employee employee = new Employee();
//        employee.setId(1);
            employee.setLastName("pink");

            //查询的时候如果某些条件没带可能sql拼装会有问题
            //1、给where后面加上1=1，以后的条件都and xxx.
            //2、mybatis使用where标签来将所有的查询条件包括在内。mybatis就会将where标签中拼装的sql，多出来的and或者or去掉
            //3、where只会去掉第一个多出来的and或者or

            //测试if\where
        List<Employee> employeeList = mapper.getEmpsByConditionIf(employee);
        System.out.println(employeeList);


            //测试Trim
//        List<Employee> employeeList1 = mapper.getEmpsByConditionTrim(employee);
//        System.out.println(employeeList1);

            //测试choose
//            employee.setId(7);
//        List<Employee> employeeList = mapper.getEmpsByConditionChoose(employee);
//        System.out.println(employeeList);

            //测试set标签对应的修改（update）
//            boolean b = mapper.updateEmp(employee);
//            System.out.println(b);

            //测试循环查询
//            List<Employee> employeeList = mapper.getEmpsByConditionForeach(Arrays.asList(1, 2, 3, 7));
//            System.out.println(employeeList);

//            mapper.addEmps(Arrays.asList(new Employee(null,"pink1","1","pink1@test.com",new Department(1)),
//                                        new Employee(null,"pink2","0","pink2@test.com",new Department(2)),
//                                        new Employee(null,"pink3","1","pink3@test.com",new Department(1))
//                    ));

//            List<Employee> employeeList = mapper.getEmpsTestInnerParameter(employee);
//            System.out.println(employeeList);

            openSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
    }

}
