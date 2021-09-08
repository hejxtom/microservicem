package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public int addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public boolean deleteEmpById(Integer id);

//  利用@Param
//    public Employee getEmpByIdAndLastName(@Param("id") Integer id,
//                                          @Param("lastName")String lastName);

//    利用Map传参
    public Employee getEmpByIdAndLastName(Map<Object, Object> map);

//返回List集合
    public List<Employee> getEmpByLastNameLike(String lastName);

    /*
    * 返回一条记录的map；key就是列名，值就是对应的值
    *
    *
    */
    public Map<String,Object> getEmpByIdReturnMap(Integer id);

    //多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
    //@MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
    @MapKey("id")
    Map<Integer,Employee> getEmpByLastNameLikeReturnMap(String lastName);

}
