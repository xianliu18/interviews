package com.noodles.thread.lock.synchronizeddemo;

/**
 * @Description: synchronized 可重入测试
 * @Author: noodles
 * @create: 2021-01-30 21:01
 */
public class SynchronizedTest {

    private final int myField = 3;

    public synchronized void method1() {
        System.out.println("do method1");
    }

    public void method2() {
        synchronized (this) {
            System.out.println("do method2");
        }
    }
}
