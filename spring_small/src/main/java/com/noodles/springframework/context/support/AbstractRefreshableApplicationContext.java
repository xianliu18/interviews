package com.noodles.springframework.context.support;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.noodles.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @description: 抽象类自动刷新上下文
 * @author: liuxian
 * @date: 2022-11-12 15:41
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
