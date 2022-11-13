package com.noodles.springframework.test.event;

import com.noodles.springframework.context.ApplicationListener;
import com.noodles.springframework.context.event.ContextClosedEvent;

/**
 * @description: 容器关闭事件监听器
 * @author: liuxian
 * @date: 2022-11-13 11:00
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}
