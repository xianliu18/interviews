package com.noodles.thread.lock;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeadLockDemo
 * @Description 死锁示例
 * @Author nooodles
 * @Date 2021/3/17 11:08
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();
    }
}

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 持有锁: " + lockA + "\t 尝试获得锁：" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB)
            {
                System.out.println(Thread.currentThread().getName() + "\t 持有锁：" + lockB + "\t 尝试获得锁: " + lockA);
            }
        }
    }
}
