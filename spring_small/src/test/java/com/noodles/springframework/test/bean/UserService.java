package com.noodles.springframework.test.bean;

import com.noodles.springframework.beans.factory.DisposableBean;
import com.noodles.springframework.beans.factory.InitializingBean;

/**
 * @description: UserService 类
 * @author: liuxian
 * @date: 2022-11-11 15:20
 */

public class UserService implements InitializingBean, DisposableBean {

    private String id;

    private String company;

    private String location;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(id) + ", 公司：" + company + ", 地点：" + location;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
