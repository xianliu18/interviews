package com.noodles.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName WaitNotifyDemo2
 * @Description 生产者和消费者Demo, 参考链接：https://stefan.blog.csdn.net/article/details/108946045
 * @Author noodles
 * @Date 2021/2/10 15:17
 */
public class WaitNotifyDemo2 {

    public static void main(String[] args) {
        final int maxCapacity = 1;
        List<Integer> store = new ArrayList<>(maxCapacity);
        Lock lock = new ReentrantLock();

        Condition notEmpty = lock.newCondition();
        Condition notFull = lock.newCondition();

        Thread producer = new Thread(() -> {
            for(;;) {
                lock.lock();
                try {
                    if (store.size() >= maxCapacity) {
                        try {
                            System.out.println("store 满了，生产者阻塞，不满等待notFull.await()");
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int rand = new Random().nextInt();
                    store.add(rand);
                    System.out.println("store 没有满，生产者生产，并唤醒消费者notEmpty.signal()");
                    notEmpty.signal();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread consumer = new Thread(() -> {
           for (;;) {
               lock.lock();
               try {
                   if (store.size() == 0) {
                       try {
                           System.out.println("store空了，消费者阻塞，不空等待notEmpty.await()");
                           notEmpty.await();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       store.remove(0);
                       System.out.println("store不空，消费者消费，不满唤醒notFull.signal()");
                       notFull.signal();
                   }
               } finally {
                   lock.unlock();
               }
           }
        });

        producer.start();
        consumer.start();
    }
}
