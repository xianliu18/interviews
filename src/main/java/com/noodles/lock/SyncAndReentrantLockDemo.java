package com.noodles.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: ReentrantLock 示例
 * @Author: noodles
 * @create: 2021-03-16 21:34
 */
/*
 * AA 打印 5 次, BB 打印 10 次, CC 打印 15 次
 * ...
 * 共打印10轮
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sharedResource.print5();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sharedResource.print10();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sharedResource.print15();
            }
        }, "C").start();
    }
}

class SharedResource{
    private int number = 1; // A: 1, B: 2, C: 3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 1, 判断
            while (number != 1) {
                c1.await();
            }

            // 2, 干活
            for (int i = 0; i <5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 3, 通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 1, 判断
            while (number != 2) {
                c2.await();
            }

            // 2, 干活
            for (int i = 0; i <10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 3, 通知
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 1, 判断
            while (number != 3) {
                c3.await();
            }

            // 2, 干活
            for (int i = 0; i <15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 3, 通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
