package com.noodles.demo;

import com.alibaba.fastjson.JSON;
import com.noodles.demo.like.mybatis.Resources;
import com.noodles.demo.like.mybatis.SqlSession;
import com.noodles.demo.like.mybatis.SqlSessionFactory;
import com.noodles.demo.like.mybatis.SqlSessionFactoryBuilder;
import com.noodles.demo.po.User;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.junit.Test;

/**
 * @Description: 测试类
 * @Author: noodles
 * @create: 2021-01-25 08:17
 */
public class ApiLikeTest {

    @Test
    public void test_queryUserInfoById() {
        String resource = "spring/mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User user = session.selectOne("com.noodles.demo.dao.IUserDao.queryUserInfoById", 1L);
                System.out.println(JSON.toJSONString(user));
            } finally {
                session.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_queryUserList() {
        String resource = "spring/mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User req = new User();
                req.setAge(18);
                List<User> userList = session.selectList("com.noodles.demo.dao.IUserDao.queryUserList", req);
            } finally {
                session.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
