package com.noodles.lock;

/**
 * @ClassName AtomicTest
 * @Description 原子性测试
 * @Author noodles
 * @Date 2021/1/19 10:53
 */
public class AtomicTest {

    private static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    add();
                }
            });
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println(counter);
    }

    public static void add() {
        synchronized (AtomicTest.class) {
            counter++;
        }
    }
}
