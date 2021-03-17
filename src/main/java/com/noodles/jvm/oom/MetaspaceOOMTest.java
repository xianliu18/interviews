package com.noodles.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName MetaspaceOOMTest
 * @Description 元空间
 *
 * 参考链接：https://www.bilibili.com/video/BV1zb411M7NQ?p=87
 *
 * 启动命令：
 *   -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=10m
 *
 * @Author noodles
 * @Date 2021/1/11 15:26
 */
public class MetaspaceOOMTest {
    static class OOMTest {
    }

    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println("*************多少次后发生了异常" + i);
            e.printStackTrace();
        }
    }
}
