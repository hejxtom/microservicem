package com.atguigu.spring5.bean;

/**
 * @Classname Orders
 * @Description TODO
 * @Date 18:41 2021/3/18
 * @Created by hejx
 */

public class Orders {

    private String oname;

    public Orders() {
        System.out.println("第一步，执行无参构造创建bean的实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步，调用set方法设置值");
    }

    //创建执行的初始化的方法
    public void initMentod(){
        System.out.println("第三步，调用初始化方法");
    }

    //创建执行的销毁方法
    public void destroyMethod(){
        System.out.println("第五步，调用销毁方法");
    }

}
