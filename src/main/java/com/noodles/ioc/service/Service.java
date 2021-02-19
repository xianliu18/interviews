package com.noodles.ioc.service;

import com.noodles.ioc.dao.Dao;
import com.noodles.ioc.dao.MongoDao;
import com.noodles.ioc.dao.MySqlDao;

/**
 * @Description:
 * @Author:
 * @create: 2021-02-19 08:12
 */
public class Service {

    private Dao mysqlDao;

    private Dao mongoDao;

    @Override
    public String toString() {
        return super.toString() + "\n\t\t\t\t\t{ " +
                "mysqlDao= " + mysqlDao +
                ", mongoDao= " + mongoDao + "}";
    }

    public void setMysqlDao(MySqlDao mysqlDao) {
        this.mysqlDao = mysqlDao;
    }

    public void setMongoDao(MongoDao mongoDao) {
        this.mongoDao = mongoDao;
    }
}
