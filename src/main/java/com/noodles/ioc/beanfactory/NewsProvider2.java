package com.noodles.ioc.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName NewsProvider2
 * @Description 实现ApplicationContextAware接口
 * 参考链接： www.tianxiaobo.com/2018/05/30/Spring-IOC-容器源码分析系列文章导读/
 * @Author noodles
 * @Date 2021/2/19 10:28
 */
public class NewsProvider2 implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private News news;

    /**
     * @Description 每次都从 applicationContext 中获取一个新的 bean
     */
    public News getNews() {
        return applicationContext.getBean("news", News.class);
    }

    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
