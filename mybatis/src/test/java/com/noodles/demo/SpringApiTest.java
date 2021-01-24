package com.noodles.demo;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.noodles.demo.dao.ISchoolDao;
import com.noodles.demo.dao.IUserDao;
import com.noodles.demo.po.School;
import com.noodles.demo.po.User;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description: spring和mybatis整合
 * @Author: noodles
 * @create: 2021-01-23 11:39
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringApiTest {

    @Resource
    private ISchoolDao schoolDao;

    @Resource
    private IUserDao userDao;

    @Test
    public void test_queryRuleTreeByTreeId() {
        School ruleTree = schoolDao.querySchoolInfoById(1L);
        log.info(JSON.toJSONString(ruleTree));

        User user = userDao.queryUserInfoById(1L);
        log.info(JSON.toJSONString(user));
    }
}
