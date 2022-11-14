package com.noodles.springframework.test.bean.autowired;

/**
 * @description: IUserService
 * @author: liuxian
 * @date: 2022-11-14 11:30
 */
public interface IUserService {

    String queryUserInfo();

    String register(String userName);

}
