package com.noodles.springframework.test.bean;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.BeanClassLoaderAware;
import com.noodles.springframework.beans.factory.BeanFactory;
import com.noodles.springframework.beans.factory.BeanFactoryAware;
import com.noodles.springframework.beans.factory.BeanNameAware;
import com.noodles.springframework.context.ApplicationContext;
import com.noodles.springframework.context.ApplicationContextAware;

/**
 * @description: UserService 类
 * @author: liuxian
 * @date: 2022-11-11 15:20
 */

public class UserService {

    private String uId;

    private String company;

    private String location;

    private IUserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + ", 公司：" + company + ", 地点：" + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
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

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
