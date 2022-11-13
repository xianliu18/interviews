package com.noodles.springframework.test.bean;

/**
 * @description: 客户 Service
 * @author: liuxian
 * @date: 2022-11-13 11:36
 */
public interface ICustomerService {

    String queryUserInfo();

    String register(String userName);

}
