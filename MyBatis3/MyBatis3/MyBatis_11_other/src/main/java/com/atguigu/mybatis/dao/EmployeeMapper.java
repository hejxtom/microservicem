package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public List<Employee> getEmps();

    public boolean addEmps(@Param("emp") Employee emp);

}
