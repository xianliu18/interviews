package com.noodles.demo.dao;

import com.noodles.demo.po.User;

import java.util.List;

/**
 *
 */
public interface IUserDao {

    User queryUserInfoById(Long id);

    List<User> queryUserList(User user);
}
