package com.atguigu.mybatis.service;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname EmployeeService
 * @Description TODO
 * @Date 11:44 2021/8/22
 * @Created by hejx
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlSession sqlSession;//此sqlSession是一个批量的sqlSession

    public List<Employee> getEmps(){

        return employeeMapper.getEmps();
    }


}
