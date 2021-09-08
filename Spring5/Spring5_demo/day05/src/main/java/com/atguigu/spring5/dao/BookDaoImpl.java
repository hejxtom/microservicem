package com.atguigu.spring5.dao;

import com.atguigu.spring5.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname BookDaoImpl
 * @Description TODO
 * @Date 19:13 2021/3/29
 * @Created by hejx
 */
@Repository
public class BookDaoImpl implements BookDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(User user) {
        int update = jdbcTemplate.update("insert into atguigu_day05 values(?,?,?)", user.getId(), user.getUsername(), user.getPassword());
        System.out.println(update);
    }

    @Override
    public void update(User user) {
        int update = jdbcTemplate.update("update atguigu_day05 set username=?,password=? where id=?", user.getUsername(), user.getPassword(), user.getId());
        System.out.println(update);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from atguigu_day05 where id=?",id);

    }

    @Override
    public int selectCount() {
        int count = jdbcTemplate.queryForObject("select count(*) from atguigu_day05", Integer.class);
        return count;
    }

    @Override
    public User selectUser(Integer id) {
        return jdbcTemplate.queryForObject("select * from atguigu_day05 where id=?",new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public List<User> selectUsers() {
        return jdbcTemplate.query("select * from atguigu_day05",new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void batchAddUser(List<Object[]> batchArgs) {
      String sql="insert into atguigu_day05 values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchupdate(List<Object[]> batchArgs) {
        String sql="update atguigu_day05 set username=?,password=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints);
    }

    @Override
    public void batchdelete(List<Object[]> batchArgs) {
        String sql="delete from atguigu_day05 where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints);
    }
}
