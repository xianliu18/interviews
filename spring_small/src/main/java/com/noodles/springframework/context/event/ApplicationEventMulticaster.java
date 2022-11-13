package com.noodles.springframework.context.event;

import com.noodles.springframework.context.ApplicationEvent;
import com.noodles.springframework.context.ApplicationListener;

/**
 * @description: 事件广播器
 * @author: liuxian
 * @date: 2022-11-13 09:30
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
