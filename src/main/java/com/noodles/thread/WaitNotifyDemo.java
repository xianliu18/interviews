package com.noodles.thread;


import java.util.LinkedList;

/**
 * @Description: 线程通信
 * @Author: noodles
 * @create: 2021-02-02 23:46
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {

        final MessageQueue mq = new MessageQueue(3);
        System.out.println("**********task begin**********");
        // 创建生产者线程并启动
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                while (true) {
                    mq.set(new Message());
                }
            }, "producer").start();
        }

        // 创建消费者线程并启动
        new Thread(() -> {
            while(true) {
                mq.get();
            }
        }, "consumer").start();
    }
}

/**
 * 消息队列
 */
class MessageQueue {

    /**
     * 队列最大值
     */
    private final int max;

    /**
     * 锁
     */
    private final byte[] lock = new byte[1];

    /**
     * final 确保发布安全
     */
    final LinkedList<Message> messageQueue = new LinkedList<Message>();

    public MessageQueue() {
        max = 10;
    }

    /**
     * 构造函数设置队列大小
     */
    public MessageQueue(int x) {
        max = x;
    }

    public void set(Message message) {
        synchronized (lock) {
            // 如果已经大于队列个数,队列满,进入等待
//            if (messageQueue.size() > max) {
            while (messageQueue.size() > max) {
                try {
                    System.out.println(Thread.currentThread().getName() + " : queue is full, waiting....");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 如果队列未满,生产消息,随后通知lock上的等待线程
            // 每一次的消息生产,都会通知消费者
            System.out.println(Thread.currentThread().getName() + " : add a message");
            messageQueue.addLast(message);
            lock.notify();
        }
    }

    public void get() {
        synchronized (lock) {
            // 如果队列为空,进入等待,无法获取消息
//            if (messageQueue.isEmpty()) {
            while (messageQueue.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": queue is empty, waiting...");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 队列非空时,读取消息,随后通知lock上的等待线程
            // 每一次的消息读取,都会通知生产者
            System.out.println(Thread.currentThread().getName() + " : get a message");
            messageQueue.removeFirst();
            lock.notify();
        }
    }
}

/**
 * 消息队列中存储的消息
 */
class Message {

}
