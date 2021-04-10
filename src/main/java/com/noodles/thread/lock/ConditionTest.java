package com.noodles.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 实现两个线程交替执行
 * @Author: noodles
 * @create: 2021-02-06 21:44
 */
public class ConditionTest {

    public static void main(String[] args) {
        // 创建资源
        Resource r = new Resource();

        ExecutorService proService = Executors.newFixedThreadPool(2);
        ExecutorService conService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            proService.execute(new Producer(r));
        }
        for (int i = 0; i < 4; i++) {
            conService.execute(new Consumer(r));
        }

        proService.shutdown();
        conService.shutdown();
    }

}

class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    // 创建一个锁对象
    Lock lock = new ReentrantLock();

    // 通过已有的锁,获取两组监视器,一组监视生产者, 一组监视消费者
    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();

    public void set(String name) {
        lock.lock();
        try {
            while (flag) {
                try {
                    producer_con.await();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "..生产者.." + this.name);
            flag = true;
            consumer_con.signal();
        } finally {
            lock.unlock();
        }
    }


    public void out() {
        lock.lock();
        try {
            while (!flag) {
                try {
                    consumer_con.await();
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
            flag = false;
            producer_con.signal();
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    Resource r;
    Producer(Resource t) {
        this.r = t;
    }

    public void run() {
        while (true) {
            r.set("烤鸭");
        }
    }
}

class Consumer implements Runnable {
    Resource r;
    Consumer(Resource r) {
        this.r = r;
    }
    public void run() {
        while (true) {
            r.out();
        }
    }
}
