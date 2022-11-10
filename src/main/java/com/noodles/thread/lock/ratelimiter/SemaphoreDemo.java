package com.noodles.thread.lock.ratelimiter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreDemo
 * @Description Semaphore 限流
 *      参考链接： https://mp.weixin.qq.com/s/37WkBzmGb4Fevbk4HQEISw
 * @Author noodles
 * @Date 2021/4/2 17:51
 */
public class SemaphoreDemo {

    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
               boolean flag = false;
               try {
                   flag = semaphore.tryAcquire(100, TimeUnit.MICROSECONDS);
                   if (flag) {
                       System.out.println(Thread.currentThread() + ", 尝试下单中......");
                       TimeUnit.SECONDS.sleep(2);
                   } else {
                       System.out.println(Thread.currentThread() + ", 秒杀失败，请稍后重试!");
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } finally {
                   if (flag) {
                       semaphore.release();
                   }
               }
            }).start();
        }
    }
}
