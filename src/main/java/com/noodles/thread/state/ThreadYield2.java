package com.noodles.thread.state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @Description: Yield 测试
 *      参考链接: https://bugstack.cn/interview/2020/12/02/面经手册-第20篇-Thread-线程-状态转换-方法使用-原理分析.html
 * @Author: noodles
 * @create: 2021-04-12 22:56
 */
public class ThreadYield2 {
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
