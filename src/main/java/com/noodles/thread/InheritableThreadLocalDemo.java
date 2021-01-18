package com.noodles.thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import io.netty.util.concurrent.FastThreadLocal;

/**
 * @ClassName InheritableThreadLocalDemo
 * @Description InheritableThreadDemo 示例
 * @Author liuxian2
 * @Date 2021/1/18 15:49
 */
public class InheritableThreadLocalDemo {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        ThreadLocal<Object> transmittableThreadLocal = new TransmittableThreadLocal<>();

        threadLocal.set("父类数据：threadLocal");
        inheritableThreadLocal.set("父类数据：inheritableThreadLocal");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程获取父类threadLocal数据：" + threadLocal.get());
                System.out.println("子线程获取父类inheritableThreadLocal数据：" + inheritableThreadLocal.get());
            }
        }).start();
    }
}
