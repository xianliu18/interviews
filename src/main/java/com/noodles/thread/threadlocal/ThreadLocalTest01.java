package com.noodles.thread.threadlocal;

/**
 * @ClassName ThreadLocalTest01
 * @Description ThreadLocal测试01
 * @Author noodles
 * @Date 2021/1/29 11:16
 */
public class ThreadLocalTest01 {

    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest01 test = new ThreadLocalTest01();

//        test.set();
        System.out.println("====== main ======");
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread1 = new Thread(() -> {
            test.set();
            System.out.println("====== thread1 ======");
            System.out.println(test.getLong());
            System.out.println(test.getString());
        });
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }

}
