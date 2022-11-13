package com.noodles.springframework.test.event;

import com.noodles.springframework.context.ApplicationListener;
import com.noodles.springframework.context.event.ContextRefreshedEvent;

/**
 * @description: 容器刷新事件监听器
 * @author: liuxian
 * @date: 2022-11-13 11:00
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件: " + this.getClass().getName());
    }
}
