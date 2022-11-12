package com.noodles.springframework.context;

import com.noodles.springframework.beans.BeansException;

/**
 * @description: 可配置应用上下文
 * @author: liuxian
 * @date: 2022-11-12 15:40
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    
    /**
     * 刷新容器
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
    
}
