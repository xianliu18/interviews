package com.noodles.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 可中断锁
 * @Author: noodles
 * @create: 2021-01-31 21:04
 * 参考资料：https://www.cnblogs.com/noteless/p/10481286.html
 */
public class ThreadInteruptDemo2 {

    private static final Lock LOCK = new ReentrantLock();


    public static void main(String[] args) {
        // 线程A获取加锁之后,持有五秒钟
        Thread threadA = new Thread(() -> {
           LOCK.lock();
           try {
               System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
               System.out.println(Thread.currentThread().getName() + " sleep");
               TimeUnit.SECONDS.sleep(10);
               System.out.println(Thread.currentThread().getName() + " " +  System.currentTimeMillis());
           } catch (InterruptedException e) {
               System.out.println(Thread.currentThread().getName() + " interrupt");
           } finally {
               LOCK.unlock();
           }
        }, "Thread-A");

        threadA.start();

        // 线程B开始后,尝试获取锁
        Thread threadB = new Thread(() -> {
//            LOCK.lock();
            try {
                LOCK.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + " working");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupt");
            } finally {
                LOCK.unlock();
            }
        }, "Thread-B");
        threadB.start();

        // 为了确保上面的任务都开始了,主线程 sleep 1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadB.interrupt();
    }
}
