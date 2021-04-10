package com.noodles.thread.lock;

/**
 * @ClassName WaitNotifyDemo
 * @Description 多线程通信
 * @Author noodles
 * @Date 2021/2/8 11:33
 */
public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        final Object object = new Object();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                synchronized (object) {
                    for (int j = 0; j < 10; j++) {
                        System.out.println("SubThread: " + (j + 1));
                    }
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            synchronized (object) {
                // 主线程让出锁
                object.wait();
                for (int j = 0; j < 100; j++) {
                    System.out.println("MainThread: " + (j + 1));
                }
                object.notify();
            }
        }
    }
}
