package com.noodles.demo.dao;

import com.noodles.demo.po.Student;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 学生接口
 */
public interface StudentDao {
    Student findOne(@Param("id") Integer id);
    int update(@Param("id")Integer id, @Param("name")String name);

    List<Student> findByPaging(@Param("id")Integer id, RowBounds rb);
}
