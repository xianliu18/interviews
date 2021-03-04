package com.noodles.demo.po;

import java.util.Date;

/**
 * @ClassName ArticleNew
 * @Description Article 类
 * @Author noodles
 * @Date 2021/3/4 9:10
 */
public class ArticleNew {
    private Integer id;
    private String title;
    private Author author;
    private String content;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ArticleNew{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
