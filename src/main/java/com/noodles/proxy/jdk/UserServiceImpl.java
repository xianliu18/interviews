package com.noodles.proxy.jdk;

/**
 * @ClassName UserServiceImpl
 * @Description 实现类
 * @Author noodles
 * @Date 2021/2/23 11:51
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save(User user) {
        System.out.println("save user info");
    }

    @Override
    public void update(User user) {
        System.out.println("update user info");
    }
}
