package com.noodles.service.impl;

import com.noodles.service.IUserApi;

/**
 * @ClassName UserApiImpl
 * @Description 实现类
 * @Author noodles
 * @Date 2021/1/18 16:56
 */
public class UserApiImpl implements IUserApi {

    @Override
    public String queryUserInfo() {
        return "天气晴朗，万里无云 By 原生方法！";
    }

}
