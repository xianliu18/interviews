package com.noodles.asm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AQSDemo
 * @Description AQS 示例
 * @Author noodles
 * @Date 2021/1/12 14:04
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        // A 线程
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("-------A thread come in");
                try {
                    TimeUnit.MINUTES.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }, "A").start();

        // B 线程
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("-----B thread come in");
            } finally {
                lock.unlock();
            }
        }, "B").start();

        // C 线程
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("----- C thread come in");
            } finally {
                lock.unlock();
            }
        }, "C").start();
    }
}
