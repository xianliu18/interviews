package com.noodles.demo;

import com.noodles.demo.po.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName SpringJdbcTest
 * @Description Spring JDBC 测试
 * @Author noodles
 * @Date 2021/2/26 18:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config-datasource.xml")
public class SpringJdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testSpringJdbc() {
        String author = "张三";
        String date = "2021-01-01";
        String sql = "SELECT id, title, author, content, create_time FROM article WHERE author = '" + author + "' AND create_time > '" + date + "'";
        List<Article> articleList = jdbcTemplate.query(sql, (rs, rowNum) -> {
           Article article = new Article();
           article.setId(rs.getInt("id"));
           article.setTitle(rs.getString("title"));
           article.setAuthor(rs.getString("author"));
           article.setContent(rs.getString("content"));
           article.setCreateTime(rs.getDate("create_time"));
           return article;
        });

        System.out.println("Query SQL => " + sql);
        System.out.println("Spring JDBC Query Result: ");
        articleList.forEach(System.out::println);
    }
}
