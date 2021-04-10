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

    private static volatile Map<String, AtomicInteger> countMap = new ConcurrentHashMap<>();
    static class Y implements Runnable {
        private String name;
        private boolean isYield;
        public Y(String name, boolean isYield) {
            this.name = name;
            this.isYield = isYield;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                if (isYield) {
                    Thread.yield();
                }
                AtomicInteger atomicInteger = countMap.get(name);
                if (null == atomicInteger) {
                    countMap.put(name, new AtomicInteger(1));
                    continue;
                }
                atomicInteger.addAndGet(1);
                countMap.put(name, atomicInteger);
            }
            System.out.println("线程编号：" + name + "执行完成耗时：" + (System.currentTimeMillis() - startTime) + "(毫秒)" + (isYield ? "让出CPU---------------" : "不让CPU"));
        }
    }

    @Test
    public void test_Yield() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            if (i < 10) {
                new Thread(new Y(String.valueOf(i), true)).start();
                continue;
            }
            new Thread(new Y(String.valueOf(i), false)).start();
        }

        Thread.sleep(50000);
    }
}
