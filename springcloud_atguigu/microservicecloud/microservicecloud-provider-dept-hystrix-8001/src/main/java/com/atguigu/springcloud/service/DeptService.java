package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.DeptEntity;

import java.util.List;

/**
 * @author hejx
 * @createTime 2020/2/15 17:19
 * @description
 */
public interface DeptService {

    /**
     * 插入
     * @param deptEntity
     * @return
     */
    boolean addDept(DeptEntity deptEntity);

    /**
     * 根据id查找
     * @param deptNo
     * @return
     */
    DeptEntity findById(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    List<DeptEntity> findAll();
}