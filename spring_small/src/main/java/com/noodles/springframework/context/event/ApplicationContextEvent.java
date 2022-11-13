package com.noodles.springframework.context.event;


import com.noodles.springframework.context.ApplicationContext;
import com.noodles.springframework.context.ApplicationEvent;

/**
 * @description: 应用上下文事件
 * @author: liuxian
 * @date: 2022-11-13 09:28
 */
public class ApplicationContextEvent extends ApplicationEvent {


    /**
     * Constructs a prototypical Event.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext)getSource();
    }
}
