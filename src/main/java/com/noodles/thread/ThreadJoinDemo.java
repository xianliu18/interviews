package com.noodles.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description: join示例
 * @Author: noodles
 * @create: 2021-02-03 08:28
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
           for (int i = 0; i < 5; i++) {
               try {
                   TimeUnit.MILLISECONDS.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName() + " : working");
           }
        });
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end");
    }
}
