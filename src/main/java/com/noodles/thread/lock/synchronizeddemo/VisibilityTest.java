package com.noodles.thread.lock.synchronizeddemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName VisibilityTest
 * @Description synchronized 可见性测试
 *      参考链接: https://bugstack.cn/interview/2020/10/28/面经手册-第15篇-码农会锁-synchronized-解毒-剖析源码深度分析.html
 * @Author noodles
 * @Date 2021/1/19 11:10
 */
@Slf4j
public class VisibilityTest {

    private static boolean sign = false;

    public static void main(String[] args) {
        Thread thread01 = new Thread(() -> {
            int i = 0;
            while (!sign) {
                i++;
                add(i);
                log.info(Thread.currentThread().getName() + "\t" + i);
//                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }, "thread01");

        Thread thread02 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sign = true;
            log.info("vt.sign = true while (!sign)");
//            System.out.println(Thread.currentThread().getName() + " vt.sign = true while (!sign)");
        }, "thread02");

        thread01.start();
        thread02.start();
    }

    public static synchronized int add(int i) {
        return i + 1;
    }
}
