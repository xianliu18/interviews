package com.noodles.springframework.test.bean.autowired;


import com.noodles.springframework.beans.factory.annotation.Autowired;
import com.noodles.springframework.beans.factory.annotation.Value;
import com.noodles.springframework.stereotype.Component;
import java.util.Random;

/**
 * @description: UserService 类
 * @author: liuxian
 * @date: 2022-11-11 15:20
 */
@Component("userService")
public class UserService implements IUserService {

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;


    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("10002") + "\t token: " + token;
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

    @Override
    public String toString() {
        return "UserService: {" +
                "token='" + token + '\'' +
                ", userDao=" + userDao +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
