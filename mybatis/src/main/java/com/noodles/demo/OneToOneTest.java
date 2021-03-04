package com.noodles.demo;

import com.noodles.demo.dao.ArticleNewDao;
import com.noodles.demo.po.ArticleNew;
import com.noodles.demo.po.Author;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName OneToOneTest
 * @Description 一对一关联查询
 * @Author noodles
 * @Date 2021/3/4 9:27
 */
public class OneToOneTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void parse() throws IOException {
        String source = "spring/mybatis-config-datasources.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testOne2One() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleNewDao articleNewDao = session.getMapper(ArticleNewDao.class);
            ArticleNew articleNew = articleNewDao.findOne(1);

            Author author = articleNew.getAuthor();
            articleNew.setAuthor(null);

            System.out.println("\n articles info: ");
            System.out.println(articleNew);

            System.out.println("\n author info: ");
            System.out.println(author);
        } finally {
            session.close();
        }
    }

    @Test
    public void testOne2One2() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleNewDao articleNewDao = session.getMapper(ArticleNewDao.class);
            ArticleNew articleNew = articleNewDao.findOne(1);

            System.out.println("\n articles info: ");
            System.out.println(articleNew);

            System.out.println("\n 延迟加载 author 字段:");
            // 通过 getter 方法触发延迟加载
            Author author = articleNew.getAuthor();
            System.out.println("\n article info: ");
            System.out.println(articleNew);
            System.out.println("\n author info: ");
            System.out.println(author);
        } finally {
            session.close();
        }
    }
}
