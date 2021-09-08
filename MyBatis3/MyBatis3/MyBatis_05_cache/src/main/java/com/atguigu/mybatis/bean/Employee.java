package com.atguigu.mybatis.bean;

import java.io.Serializable;

/**
 * @Classname Employee
 * @Description TODO
 * @Date 16:47 2021/8/19
 * @Created by hejx
 */

public class Employee  implements Serializable {
    private Integer id;
    private String lastName;
    private String email;
    private String gender;
    private Department dep;


    public Employee(Integer id, String lastName,  String gender, String email,Department dep) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dep = dep;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dep=" + dep +
                '}';
    }
}
