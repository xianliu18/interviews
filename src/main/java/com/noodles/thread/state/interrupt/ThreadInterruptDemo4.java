package com.noodles.thread.state.interrupt;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName InterruptDemo
 * @Description 线程中断示例，链接：https://blog.csdn.net/yasinshaw/article/details/107328906
 * @Author noodles
 * @Date 2021/2/8 17:51
 */
public class ThreadInterruptDemo4 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
    }

    @Test
    public void interruptDemo2() {
        Thread t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("first parked");
            Thread.currentThread().isInterrupted();
            LockSupport.park(); // 这里不会被阻塞，因为中断位是true
            System.out.println("second parked");
            Thread.interrupted();
            LockSupport.park(); // 这里会被阻塞，因为中断位是false
            System.out.println("third parked");
        });
        t2.start();
        System.out.println("abc...");
        t2.interrupt(); // 中断，唤醒第一次park
    }
}
