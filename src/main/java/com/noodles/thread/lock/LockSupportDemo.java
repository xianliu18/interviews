package com.noodles.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockSupportDemo
 * @Description LockSupport 示例
 *
 * 参考链接: https://www.bilibili.com/video/BV1zb411M7NQ?p=131
 *
 * @Author noodles
 * @Date 2021/1/12 11:40
 */
public class LockSupportDemo {

    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();



    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t ------come in");
            LockSupport.park(); // 被阻塞，等待许可证
            System.out.println(Thread.currentThread().getName() + "\t -------被唤醒");
        }, "a");
        a.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread b = new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t ------通知");
        }, "b");
        b.start();
    }

    /**
     * @Author noodles
     * @Description condition 和 signal 机制
     */
    private static void ConditionAwaitSignal() {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t -----------come in");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t ---------------被唤醒");
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t ------------通知");
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

    /**
     * @Author noodles
     * @Description wait 和 notify 机制
     */
    private static void objectWaitNotify() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t -----------come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t =========被唤醒");
            }

        }, "A").start();

        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t ===============通知动作");
            }
        }, "B").start();
    }
}
