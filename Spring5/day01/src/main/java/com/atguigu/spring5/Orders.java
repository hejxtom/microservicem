package com.atguigu.spring5;

/**
 * @Classname Orders
 * @Description TODO
 * @Date 20:33 2021/3/15
 * @Created by hejx
 */

public class Orders {
    private String oname;
    private String address;


    public void setOname(String oname) {
        this.oname = oname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void testDemo(){
        System.out.println(oname);
        System.out.println(address);
    }
}
