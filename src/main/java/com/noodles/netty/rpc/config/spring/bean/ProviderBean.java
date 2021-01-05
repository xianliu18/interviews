package com.noodles.netty.rpc.config.spring.bean;

import com.noodles.netty.rpc.config.ProviderConfig;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Description: 生产者实体
 * @Author: noodles
 * @create: 2021-01-05 07:34
 */
public class ProviderBean extends ProviderConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 发布生产者
        doExport();
    }
}
