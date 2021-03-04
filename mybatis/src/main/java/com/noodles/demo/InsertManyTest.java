package com.noodles.demo;

import com.noodles.demo.dao.AuthorDao;
import com.noodles.demo.po.Author;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName InsertManyTest
 * @Description 插入数据测试
 * @Author noodles
 * @Date 2021/3/4 19:59
 */
public class InsertManyTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "spring/mybatis-config-datasources.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testInsertMany() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Author> authors = new ArrayList<>();
            // 添加多个 Author 对象到 authors 中
            authors.add(new Author("张三", 20, 0, "1@163.com"));
            authors.add(new Author("李四", 18, 0, "1@163.com"));

            System.out.println("\n Before Insert: ");
            authors.forEach(author -> System.out.println(" " + author));
            System.out.println();

            AuthorDao authorDao = session.getMapper(AuthorDao.class);
            authorDao.insertMany(authors);
            session.commit();

            System.out.println("\n After Insert: ");
            authors.forEach(author -> System.out.println(" " + author));
        } finally {
            session.close();
        }
    }
}
