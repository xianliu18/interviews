package com.noodles.thread.state;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadTest
 * @Description 线程状态测试
 * @Author noodles
 * @Date 2021/1/20 12:01
 */
public class ThreadStateTest {

    @Test
    public void test_New() {
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState());
    }

    @Test
    public void test_Runnable() {
        Thread thread = new Thread(()->{});
        // 启动
        thread.start();
        System.out.println(thread.getState());
    }

    @Test
    public void test_Blocked() throws InterruptedException {
        Object obj = new Object();
        new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread thread = new Thread(() -> {
           synchronized (obj) {
               try {
                   obj.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        thread.start();
        while (true) {
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
    }

    @Test
    public void test_TimedWaiting() throws InterruptedException {
        Object obj = new Object();
        Thread thread = new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        while (true) {
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
    }

    @Test
    public void test_Terminated() {
        Thread thread = new Thread(() -> {});

        thread.start();

        System.out.println(thread.getState());
        System.out.println(thread.getState());
        System.out.println(thread.getState());
    }

}
