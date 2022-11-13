package com.noodles.springframework.context;

import java.util.EventListener;

/**
 * @description: 应用监听器
 * @author: liuxian
 * @date: 2022-11-13 09:29
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);

}
