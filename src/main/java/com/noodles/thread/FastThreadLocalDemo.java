package com.noodles.thread;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.FastThreadLocal;

/**
 * @ClassName FastThreadLocalDemo
 * @Description FastThreadLocal 测试
 * @Author noodles
 * @Date 2021/1/18 16:35
 */
public class FastThreadLocalDemo {

    public static final int MAX = 100000;

    public static void main(String[] args) {
        new Thread(() -> threadLocal()).start();
        new Thread(() -> fastThreadLocal()).start();
    }

    private static void fastThreadLocal() {
        long start = System.currentTimeMillis();
        DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory(FastThreadLocalDemo.class);

        FastThreadLocal<String>[] fastThreadLocals = new FastThreadLocal[MAX];

        for (int i = 0; i < MAX; i++) {
            fastThreadLocals[i] = new FastThreadLocal<>();
        }

        Thread thread = defaultThreadFactory.newThread(() -> {
            for (int i = 0; i < MAX; i++) {
                fastThreadLocals[i].set("java: " + i);
            }

            System.out.println("fastThreadLocal set:" + (System.currentTimeMillis() - start));

            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    fastThreadLocals[i].get();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("fastThreadLocal total: " + (System.currentTimeMillis() - start));
    }

    private static void threadLocal() {
        long start = System.currentTimeMillis();
        ThreadLocal<String>[] threadLocals = new ThreadLocal[MAX];

        for (int i = 0; i < MAX; i++) {
            threadLocals[i] = new ThreadLocal<>();
        }

        Thread thread = new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                threadLocals[i].set("java: " + i);
            }

            System.out.println("threadLocal set: " + (System.currentTimeMillis() - start));

            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    threadLocals[i].get();
                }
            }
        });
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("threadLocal total:" + (System.currentTimeMillis() - start));
    }


}
