package com.atguigu.spring5;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 10:16 2021/3/24
 * @Created by hejx
 */

public interface UserDao {
    /**
     * 连接点：类中哪些方法可以被增强
     */
    public int add(int a, int b);

    public String update(String id);

}
