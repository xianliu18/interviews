package com.noodles.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName VisibilityTest
 * @Description 可见性测试
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
            }
        }, "thread01");

        Thread thread02 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sign = true;
            System.out.println(Thread.currentThread().getName() + " vt.sign = true while (!sign)");
        }, "thread02");

        thread01.start();
        thread02.start();
    }

    public static synchronized int add(int i) {
        return i + 1;
    }
}
