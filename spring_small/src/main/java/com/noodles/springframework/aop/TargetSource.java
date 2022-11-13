package com.noodles.springframework.aop;

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
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
