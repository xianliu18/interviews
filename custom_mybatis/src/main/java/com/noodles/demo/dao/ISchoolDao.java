package com.noodles.demo.dao;

import com.noodles.demo.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
