package com.noodles.demo.dao;

import com.noodles.demo.po.ArticleNew;
import com.noodles.demo.po.Author;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName ArticleNewDao
 * @Description ArticleNew
 * @Author noodles
 * @Date 2021/3/4 9:12
 */
public interface ArticleNewDao {
    ArticleNew findOne(@Param("id") int id);
    Author findAuthor(@Param("id") int authorId);
}
