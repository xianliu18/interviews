package com.noodles.thread.printnum;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 三个线程，一个线程负责打印1，4，7，……；第二个负责打印2，5，8，……，第三个负责打印3，6，9
 *      参考链接: https://zhuanlan.zhihu.com/p/110001146
 * @Author: noodles
 * @create: 2021-05-09 17:01
 */
public class DemoTask implements Runnable {

    private static final Object lock = new Object();
    private static final int MAX = 10;
    private static int current = 1;

    private int index;
    public DemoTask(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        while (current <= MAX) {
            synchronized (lock) {
                if ((current <= MAX) && (current % 3 == index)) {
                    System.out.println(current++);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = Arrays.asList(
                new Thread(new DemoTask(0)),
                new Thread(new DemoTask(1)),
                new Thread(new DemoTask(2))
        );

        threadList.forEach(Thread::start);
        for (Thread thread : threadList) {
            thread.join();
        }
    }
}
