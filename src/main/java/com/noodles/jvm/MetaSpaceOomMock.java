package com.noodles.jvm;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @Description: OOM 异常测试
 * @Author: noodles
 * @create: 2021-01-21 22:23
 */
public class MetaSpaceOomMock {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(5000);

        ClassLoadingMXBean loadingMXBean = ManagementFactory.getClassLoadingMXBean();
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaSpaceOomMock.class);
            enhancer.setCallbackTypes(new Class[]{Dispatcher.class, MethodInterceptor.class});
            enhancer.setCallbackFilter(new CallbackFilter() {
                @Override
                public int accept(Method method) {
                    return 1;
                }
                @Override
                public boolean equals(Object obj) {
                    return super.equals(obj);
                }
            });
            System.out.println(enhancer.createClass().getName() + loadingMXBean.getTotalLoadedClassCount() + loadingMXBean.getLoadedClassCount() + loadingMXBean.getUnloadedClassCount());
        }
    }
}
