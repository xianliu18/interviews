package com.noodles.springframework.context.support;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.config.BeanPostProcessor;
import com.noodles.springframework.context.ApplicationContext;
import com.noodles.springframework.context.ApplicationContextAware;

/**
 * @description: ApplicationContextAwareProcessor
 * @author: liuxian
 * @date: 2022-11-12 21:57
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
