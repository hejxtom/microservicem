package com.atguigu.spring5.collectiontype;

/**
 * @Classname Couse
 * @Description TODO
 * @Date 8:40 2021/3/17
 * @Created by hejx
 */

public class Couse {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }


    @Override
    public String toString() {
        return "Couse{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
