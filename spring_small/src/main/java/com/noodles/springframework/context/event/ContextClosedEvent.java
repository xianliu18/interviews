package com.noodles.springframework.context.event;

/**
 * @description: 应用上下文关闭事件
 * @author: liuxian
 * @date: 2022-11-13 09:28
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
