package com.atguigu.spring5.dao;

import com.atguigu.spring5.entiy.User;

import java.util.List;

/**
 * @Classname BookDao
 * @Description TODO
 * @Date 19:12 2021/3/29
 * @Created by hejx
 */

public interface BookDao {
    void add(User user);

    void update(User user);

    void delete(Integer id);

    int selectCount();

    User selectUser(Integer id);

    List<User> selectUsers();

    void batchAddUser(List<Object[]> batchArgs);

    void batchupdate(List<Object[]> batchArgs);

    void batchdelete(List<Object[]> batchArgs);
}
