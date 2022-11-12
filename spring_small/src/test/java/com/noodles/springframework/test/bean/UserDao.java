package com.noodles.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: UserDao 类
 * @author: liuxian
 * @date: 2022-11-11 17:28
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "李白");
        hashMap.put("10002", "阿狸");
        hashMap.put("10003", "大鱼");
    }

    public String queryUserName(String id) {
        return hashMap.get(id);
    }
}
