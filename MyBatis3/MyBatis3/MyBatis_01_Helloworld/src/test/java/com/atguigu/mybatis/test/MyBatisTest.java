package com.atguigu.mybatis.test;

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
 * @Date 8:25 2021/8/17
 * @Created by hejx
 *
 * 1、接口式编程
 * 	原生：		Dao		====>  DaoImpl
 * 	mybatis：	Mapper	====>  xxMapper.xml
 *
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 * 		（将接口和xml进行绑定）
 * 		EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
 * 5、两个重要的配置文件：
 * 		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息
 * 		sql映射文件：保存了每一个sql语句的映射信息：
 * 					将sql抽取出来。
 *
 */

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    //接口式编程（推荐）
    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        //1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession实例,能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.getEmpById(1);
        System.out.println(mapper.getClass());
        System.out.println(employee);

        openSession.close();
    }


    /**
     * 1. 根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
     *    有数据源一些运行环境信息
     * 2. sql映射文件配置了每一个sql,以及sql封装的规则等
     * 3. 将sql映射文件注册在全局配置文件中
     * 4. 写代码：
     *    1）.根据全局配置文件得到SqlSessionFactory
     *    2）.使用SqlSession工厂，获取到SqlSession对象，使用它来执行增删改查
     *        一个SqlSession对象就是代表和数据库一次会话，用完关闭
     *    3）.使用sql的唯一标识来告诉MYBatis执行哪个sql。sql都是保存在sql映射文件中
     *
     *
     *
     */
    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession实例,能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();

        /* 3.获取接口的实现类
        * selectOne():
        * 参数1：sql的唯一标识
        * 参数二：执行sql要用的参数
        *
        */
        Employee employee = openSession.selectOne("com.atguigu.mybatis.dao.EmployeeMapper.getEmpById", 1);
        System.out.println(employee);

        openSession.close();
    }
}
