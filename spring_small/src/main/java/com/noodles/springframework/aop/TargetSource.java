package com.noodles.springframework.aop;

import com.noodles.springframework.utils.ClassUtils;

/**
 * @description: 被代理的目标对象
 * @author: liuxian
 * @date: 2022-11-13 11:26
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
