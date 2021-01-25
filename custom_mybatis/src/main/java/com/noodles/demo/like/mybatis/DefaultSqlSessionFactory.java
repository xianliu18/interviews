package com.noodles.demo.like.mybatis;

/**
 * @Description:
 * @Author: noodles
 * @create: 2021-01-24 22:52
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration.connection, configuration.mapperElement);
    }
}
