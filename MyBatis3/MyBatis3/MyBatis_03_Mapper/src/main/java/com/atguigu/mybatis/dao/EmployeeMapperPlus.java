package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

import java.util.List;

/**
 * @Classname EmployeeMapperPlus
 * @Description TODO
 * @Date 8:33 2021/8/19
 * @Created by hejx
 */

public interface EmployeeMapperPlus {

    public Employee getEmpById(Integer id);


    public Employee getEmpAndDept(Integer id);

    public Employee getEmpByIdStep(Integer id);

    public Employee getEmpByIdStep1(Integer id);

    public List<Employee> getEmpsByDeptId(Integer deptId);

}
