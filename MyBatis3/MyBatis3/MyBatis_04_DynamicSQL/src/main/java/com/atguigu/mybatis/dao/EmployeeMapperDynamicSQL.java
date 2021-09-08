package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname EmployeeMapperDynamicSQL
 * @Description TODO
 * @Date 16:43 2021/8/19
 * @Created by hejx
 */

public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmpsTestInnerParameter(Employee employee);

    //携带了哪个字段查询条件就带上这个字段的值
    public List<Employee> getEmpsByConditionIf(Employee employee);

    public List<Employee> getEmpsByConditionTrim(Employee employee);

    public List<Employee> getEmpsByConditionChoose(Employee employee);

    public boolean updateEmp(Employee employee);

    public List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);


    public boolean addEmps(@Param("emps")List<Employee> emps);

}
