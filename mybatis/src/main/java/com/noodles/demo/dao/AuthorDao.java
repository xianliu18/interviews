package com.noodles.demo.dao;

import com.noodles.demo.po.Author;

import java.util.List;

public interface AuthorDao {
    int insertMany(List<Author> author);
}
