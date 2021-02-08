package com.noodles.lock;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName AtomicLongAdderTest
 * @Description AtomicLong 和 LongAdder 耗时测试
 * @Author noodles
 * @Date 2021/2/7 10:47
 */
public class AtomicLongAdderTest {
    public static void main(String[] args) throws InterruptedException {
        testAtomicLongAdder(1, 10000000);
        testAtomicLongAdder(10, 10000000);
        testAtomicLongAdder(100, 10000000);
    }

    static void testAtomicLongAdder(int threadCount, int times) throws InterruptedException {
        System.out.println("threadCount: " + threadCount + ", times: " + times);
        long start = System.currentTimeMillis();
        testLongAdder(threadCount, times);
        System.out.println("LongAdder 耗时： " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadCount: " + threadCount + ", times: " + times);
        long atomicStart = System.currentTimeMillis();
        testAtomicLong(threadCount, times);
        System.out.println("AtomicLong 耗时： " + (System.currentTimeMillis() - atomicStart) + " ms");
        System.out.println("----------------------------------");
    }

    static void testAtomicLong(int threadCount, int times) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong();
        List<Thread> list = Lists.newArrayList();
        for (int i = 0; i < threadCount; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    atomicLong.incrementAndGet();
                }
            }));
        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }

        System.out.println("AtomicLong value is : " + atomicLong.get());
    }

    static void testLongAdder(int threadCount, int times) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        List<Thread> list = Lists.newArrayList();
        for (int i = 0; i < threadCount; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    longAdder.increment();
                }
            }));
        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }

        System.out.println("LongAdder value is : " + longAdder.longValue());
    }
}
