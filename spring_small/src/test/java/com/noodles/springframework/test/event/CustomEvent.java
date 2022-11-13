package com.noodles.springframework.test.event;

import com.noodles.springframework.context.event.ApplicationContextEvent;

/**
 * @description: 自定义事件
 * @author: liuxian
 * @date: 2022-11-13 10:59
 */
public class CustomEvent extends ApplicationContextEvent {

    private Long id;
    private String message;

    public CustomEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
