package com.noodles.demo.dao;

import com.noodles.demo.po.User;

/**
 * 用户Dao层
 */
public interface IUserDao {

    User queryUserInfoById(Long id);

    String queryUserInfo();

}
