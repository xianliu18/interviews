package com.noodles.demo.dao;

import com.noodles.demo.po.Student;

import org.apache.ibatis.annotations.Param;

/**
 * 学生接口
 */
public interface StudentDao {
    Student findOne(@Param("id") Integer id);
    int update(@Param("id")Integer id, @Param("name")String name);
}
