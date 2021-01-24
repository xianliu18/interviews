package com.noodles.demo.dao;

import com.noodles.demo.po.School;

/**
 * 学校Dao层
 */
public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
