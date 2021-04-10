package com.noodles.thread.state;

import java.util.concurrent.TimeUnit;

/**
 * @Description: join示例
 *      参考链接: https://www.cnblogs.com/noteless/p/10443446.html
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
