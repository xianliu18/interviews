package com.noodles.thread.printnum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 三个线程，一个线程负责打印1，4，7，……；第二个负责打印2，5，8，……，第三个负责打印3，6，9
 *      参考链接: https://zhuanlan.zhihu.com/p/110001146
 * @Author: noodles
 * @create: 2021-05-09 17:09
 */
public class DemoTask2 implements Runnable {

    // 主线程要等待线程打印完毕, 使用 CountDownLatch 通知机制
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static List<ExecutorService> threadList = new ArrayList<>();
    private static final int MAX = 1024;
    private static int current = 1;

    @Override
    public void run() {
        if (current <= MAX) {
            System.out.println(current++ + "====" + Thread.currentThread().getName());
            threadList.get(current % threadList.size()).submit(new DemoTask2());
        } else {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            threadList.add(Executors.newFixedThreadPool(1));
        }

        threadList.get(0).submit(new DemoTask2());
        countDownLatch.await();
        threadList.forEach(ExecutorService::shutdown);
    }
}
