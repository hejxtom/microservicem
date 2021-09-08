package com.atguigu.spring5.autowire;

/**
 * @Classname Emp
 * @Description TODO
 * @Date 19:09 2021/3/18
 * @Created by hejx
 */

public class Emp {

    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }


}
