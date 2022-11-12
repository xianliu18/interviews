package com.noodles.springframework.context.support;

import com.noodles.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.noodles.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @description: XML 上下文抽象类
 * @author: liuxian
 * @date: 2022-11-12 15:41
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            reader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
