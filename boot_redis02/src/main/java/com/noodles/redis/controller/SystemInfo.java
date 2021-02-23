package com.noodles.redis.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.StandardServletEnvironment;

/**
 * @Description: Spring MVC 示例
 * @Author: noodles
 * @create: 2021-02-23 21:12
 */
@RestController
@RequestMapping("/systeminfo")
public class SystemInfo implements ApplicationContextAware, EnvironmentAware {

    private ApplicationContext applicationContext;

    private Environment environment;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext.getClass());
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping("/env")
    public String environment() {
        StandardServletEnvironment sse = (StandardServletEnvironment)environment;
        Map<String, Object> envs = sse.getSystemEnvironment();
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------++ System Environment ++--------------------<br/>");

        List<String> list = new ArrayList<>();
        list.addAll(envs.keySet());

        for (int i = 0; i < 5 && i < list.size(); i++) {
            String key = list.get(i);
            Object val = envs.get(key);
            sb.append(String.format("%s = %s<br/>", key, val.toString()));
        }

        Map<String, Object> props = sse.getSystemProperties();
        sb.append("-------------------++ System Properties ++--------------------<br/>");
        list.clear();
        list.addAll(props.keySet());
        for (int i = 0; i < 5 && i < list.size(); i++) {
            String key = list.get(i);
            Object val = props.get(key);
            sb.append(String.format("%s = %s\n", key, val.toString()));
        }

        return sb.toString();
    }

    @RequestMapping("/beans")
    public String listBeans() {
        ListableBeanFactory lbf = applicationContext;
        String[] beanNames = lbf.getBeanDefinitionNames();
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------++ Bean Info ++------------------<br/>");
        Arrays.stream(beanNames).forEach(beanName -> {
           Object bean = lbf.getBean(beanName);
           sb.append(String.format("beanName = %s\n", beanName));
           sb.append(String.format("beanClass = %s\n\n", bean.getClass().toString()));
        });

        return sb.toString();
    }
}
