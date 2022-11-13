package com.noodles.springframework.aop.framework;

import com.noodles.springframework.aop.AdvisedSupport;

/**
 * @description: 代理工厂
 * @author: liuxian
 * @date: 2022-11-13 16:49
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
