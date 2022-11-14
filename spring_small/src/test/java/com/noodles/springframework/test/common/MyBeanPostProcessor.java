package com.noodles.springframework.test.common;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.config.BeanPostProcessor;
import com.noodles.springframework.test.bean.autowired.UserService;

/**
 * @description: 自定义 BeanPostProcesser
 * @author: liuxian
 * @date: 2022-11-12 15:37
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService)bean;
//            userService.setLocation("北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行 postProcessAfterInitialization。。。");
        return bean;
    }
}
