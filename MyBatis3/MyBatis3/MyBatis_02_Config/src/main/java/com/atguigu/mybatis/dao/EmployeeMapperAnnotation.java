package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @Classname EmployeeMapperAnnotation
 * @Description TODO
 * @Date 17:01 2021/8/17
 * @Created by hejx
 */

public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id=#{id} ")
    public Employee getEmpById(Integer id);
}
