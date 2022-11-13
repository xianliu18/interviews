package com.noodles.springframework.beans.factory.support;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.DisposableBean;
import com.noodles.springframework.beans.factory.config.SingletonBeanRegistry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: 默认实现
 * @author: liuxian
 * @date: 2022-11-11 15:46
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected static final Object NULL_OBJECT = new Object();

    private final Map<String, Object> singletonObjects = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name [ " + beanName + " ] throw an exception.", e);
            }
        }

    }
}
