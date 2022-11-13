package com.noodles.springframework.test.bean;

import java.util.Random;

/**
 * @description: 客户 Service 实现类
 * @author: liuxian
 * @date: 2022-11-13 11:36
 */
public class CustomerService implements ICustomerService {

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "666，10002，上海";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success!";
    }
}
