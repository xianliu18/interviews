package com.noodles.demo.dao;

import com.noodles.demo.po.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * @ClassName ArticleMapper
 * @Description ArticleMapper 类
 * @Author noodles
 * @Date 2021/3/3 19:26
 */
public class ArticleMapper {
    public void select(@Param("id")Integer id, @Param("author") String author, RowBounds rb, Article article) {}
}
