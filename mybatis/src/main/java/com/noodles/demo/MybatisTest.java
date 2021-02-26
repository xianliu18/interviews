package com.noodles.demo;

import com.noodles.demo.dao.ArticleDao;
import com.noodles.demo.po.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Description 测试类
 * @Author noodles
 * @Date 2021/2/26 17:09
 */
public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "spring/mybatis-config-datasources.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testMybatis() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            List<Article> articleList = articleDao.findByAuthorAndCreateTime("张三", "2021-01-01");
            for (Article article : articleList) {
                System.out.println(article.getCreateTime());
            }
        } finally {
            session.commit();
            session.close();
        }
    }
}
