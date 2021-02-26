package com.noodles.demo.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName Article
 * @Description
 * 参考链接： www.tianxiaobo.com/2018/07/16/MyBatis-源码分析系列文章导读/
 * @Author noodles
 * @Date 2021/2/26 16:58
 */
@Getter
@Setter
public class Article {
    private Integer id;
    private String title;
    private String author;
    private String content;
    private Date createTime;
}
