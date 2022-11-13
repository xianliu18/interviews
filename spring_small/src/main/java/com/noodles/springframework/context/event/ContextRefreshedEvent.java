package com.noodles.springframework.context.event;

/**
 * @description: 应用上下文刷新事件
 * @author: liuxian
 * @date: 2022-11-13 09:28
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
