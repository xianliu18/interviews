package com.noodles.lock;

/**
 * @Description: Join 测试
 * @Author: noodles
 * @create: 2021-01-20 21:06
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("thread before");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread after");
        });
        thread.start();
        System.out.println("main begin!");
        thread.join();
        System.out.println("main end!");
    }
}
