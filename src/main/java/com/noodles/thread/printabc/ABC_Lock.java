package com.noodles.thread.printabc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: A B C 打印
 * @Author: noodles
 * @create: 2021-05-18 16:10
 */
public class ABC_Lock {

    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; ) {
                try {
                    lock.lock();
                    while (state %3 == 0) {
                        System.out.println("A");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; ) {
                try {
                    lock.lock();
                    while (state %3 == 1) {
                        System.out.println("B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; ) {
                try {
                    lock.lock();
                    while (state %3 == 2) {
                        System.out.println("C");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
