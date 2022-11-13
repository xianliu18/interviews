package com.noodles.springframework.context;

/**
 * @description: 事件发布者接口
 * @author: liuxian
 * @date: 2022-11-13 09:29
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);

}
