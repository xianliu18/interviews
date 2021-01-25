package com.noodles.demo;

/**
 * @Description: service 层
 * @Author: noodles
 * @create: 2021-01-24 19:57
 */
public class UserService {

    public String queryUserInfo(Long userId) {
        return "张三的id: " + userId;
    }
}
