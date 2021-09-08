package com.atguigu.spring5.bean;

/**
 * @Classname Emp
 * @Description TODO
 * @Date 17:11 2021/3/16
 * @Created by hejx
 */

public class Emp {
    private String ename;
    private String gender;

    //员工属于某一个部门( 一对多)
    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void add() {

        System.out.println("ename:"+ename);
        System.out.println("gender:"+gender);
        System.out.println("dept:"+dept);
        System.out.println("dept.dname:"+dept.getDname());
    }
}
