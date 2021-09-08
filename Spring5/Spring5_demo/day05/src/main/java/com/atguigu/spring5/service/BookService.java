package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.BookDao;
import com.atguigu.spring5.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname BookService
 * @Description TODO
 * @Date 19:12 2021/3/29
 * @Created by hejx
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    //添加的方法
    public void addUser(User user) {
        bookDao.add(user);
    }

    //修改的方法
    public void updateUser(User user) {
        bookDao.update(user);
    }

    //删除的方法
    public void deleteUser(Integer id) {
        bookDao.delete(id);
    }

    //查询的方法
    public int selectCount() {
        return bookDao.selectCount();
    }

    public User selectUser(Integer id) {
        return bookDao.selectUser(id);
    }

    public List<User> selectUsers() {
        return bookDao.selectUsers();
    }


    //批量操作
    //批量添加操作
    public void batchAdd(List<Object[]> batchArgs) {

        bookDao.batchAddUser(batchArgs);

    }

    //批量修改
    public void batchupdate(List<Object[]> batchArgs) {

        bookDao.batchupdate(batchArgs);

    }
    //批量删除
    public void batchdelete(List<Object[]> batchArgs) {

        bookDao.batchdelete(batchArgs);

    }



}
