package com.noodles.proxy.cglib2;

import com.noodles.proxy.jdk.ProxyCreator;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @ClassName CglibProxyCreator
 * @Description CGLIB 代理创建者
 * @Author noodles
 * @Date 2021/2/23 13:39
 */
public class CglibProxyCreator implements ProxyCreator {

    private Object target;

    private MethodInterceptor methodInterceptor;

    public CglibProxyCreator(Object target, MethodInterceptor methodInterceptor) {
        assert (target != null && methodInterceptor != null);
        this.target = target;
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类
        enhancer.setSuperclass(target.getClass());
        // 设置代理逻辑
        enhancer.setCallback(methodInterceptor);
        // 创建代理对象
        return enhancer.create();
    }
}
