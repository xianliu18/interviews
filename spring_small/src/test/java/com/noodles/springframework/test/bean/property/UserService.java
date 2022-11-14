package com.noodles.springframework.test.bean.property;

import com.noodles.springframework.test.bean.autowired.IUserService;
import java.util.Random;

/**
 * @description: UserService
 * @author: liuxian
 * @date: 2022-11-14 12:25
 */
public class UserService implements IUserService {

    private String token;

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "666，10002，上海" + "\t token: " + token;
    }

    @Override
    public String register(String userName) {
        return "abc";
    }
}
