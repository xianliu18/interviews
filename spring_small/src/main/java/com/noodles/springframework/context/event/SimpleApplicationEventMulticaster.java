package com.noodles.springframework.context.event;

import com.noodles.springframework.beans.factory.BeanFactory;
import com.noodles.springframework.context.ApplicationEvent;
import com.noodles.springframework.context.ApplicationListener;

/**
 * @description: 默认事件广播器
 * @author: liuxian
 * @date: 2022-11-13 09:30
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
