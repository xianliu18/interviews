package com.noodles.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReEntrentLockDemo
 * @Description 可重入锁
 * @Author noodles
 * @Date 2021/1/12 10:59
 */
public class ReEntrentLockDemo {

    static Lock lock = new ReentrantLock();




    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("====外层");
                lock.lock();
                try {
                    System.out.println("======中层");
                    lock.lock();
                    try {
                        System.out.println("======内层");
                    } finally {
                        lock.unlock();
                    }
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
