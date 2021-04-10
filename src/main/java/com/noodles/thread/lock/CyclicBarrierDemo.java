package com.noodles.thread.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CyclicBarrierDemo
 * @Description CyclicBarrier 示例
 * @Author noodles
 * @Date 2021/2/8 11:24
 */
public class CyclicBarrierDemo {

    private final static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new MyBarrierAction());
    private final static AtomicInteger atcIx = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i != 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " start");
                    Thread.sleep(atcIx.getAndIncrement() * 1000);
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " stop");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i).start();
        }
    }

    private static class MyBarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println("MyBarrierAction is call.");
        }
    }
}
