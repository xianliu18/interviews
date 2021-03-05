package com.noodles.demo;

import com.noodles.demo.dao.StudentDao;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description: 自定义插件测试类
 * 参考连接: www.tianxiaobo.com/2018/08/26/MyBatis-源码分析-插件机制/
 * @Author: noodles
 * @create: 2021-03-05 12:37
 */
public class PluginTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "spring/mybatis-config-datasources.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testPlugin() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            studentDao.findByPaging(1, new RowBounds(20, 10));
        } finally {
            sqlSession.close();
        }
    }
}
