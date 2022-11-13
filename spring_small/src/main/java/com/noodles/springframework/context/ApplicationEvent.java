package com.noodles.springframework.context;

import java.util.EventObject;

/**
 * @description: 应用事件抽象类
 * @author: liuxian
 * @date: 2022-11-13 09:29
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
