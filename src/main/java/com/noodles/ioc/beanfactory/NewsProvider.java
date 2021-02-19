package com.noodles.ioc.beanfactory;

/**
 * @ClassName NewsProvider
 * @Description BeanFactory 示例
 * @Author noodles
 * @Date 2021/2/19 10:17
 */
public class NewsProvider {

    private News news;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
