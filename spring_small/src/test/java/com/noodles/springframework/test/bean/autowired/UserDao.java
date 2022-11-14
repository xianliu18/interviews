package com.noodles.springframework.test.bean.autowired;

import com.noodles.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: UserDao
 * @author: liuxian
 * @date: 2022-11-14 11:27
 */
@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "张三，广东，广州");
        hashMap.put("10002", "老干妈，四川，成都");
        hashMap.put("10003", "哈密瓜，新疆，吐鲁番");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
