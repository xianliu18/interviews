package com.noodles.proxy.cglib2;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName TankRemanufature
 * @Description 方法拦截器
 * @Author noodles
 * @Date 2021/2/23 13:43
 */
public class TankRemanufature implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("run")) {
            System.out.println("正在改造59坦克...");
            System.out.println("改造完成，已获取--超音速飞行版");
            System.out.println("已起飞，正在突破音障...");

            methodProxy.invokeSuper(o, objects);

            System.out.println("拦截导弹成功，正在返航");
            return null;
        }

        return methodProxy.invokeSuper(o, objects);
    }
}
