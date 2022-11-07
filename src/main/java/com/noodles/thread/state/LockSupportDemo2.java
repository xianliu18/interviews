package com.noodles.thread.state;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description: LockSupport 示例
 *      参考链接: https://blog.csdn.net/yasinshaw/article/details/107328906
 *      park 遇到线程中断标识被设置为true后，「会立即返回不再阻塞，但不会抛出异常」。
 * @Author: noodles
 * @create: 2021-04-12 21:36
 */
public class LockSupportDemo2 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println("first parked");
            Thread.currentThread().isInterrupted();
            LockSupport.park(); // 这里不会被阻塞, 因为中断位是 true
            System.out.println("second parked");
            Thread.interrupted();
            LockSupport.park(); // 这里会被阻塞, 因为中断位是 false
            System.out.println("Third parked");
        });
        thread.start();
        thread.interrupt(); // 中断, 唤醒第一次 park
    }
}
