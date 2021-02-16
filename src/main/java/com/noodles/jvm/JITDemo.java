package com.noodles.jvm;

/**
 * @Description: 逃逸分析之对象的栈上内存分配
 * @Author: noodles
 * @create: 2021-02-16 20:40
 */
public class JITDemo {

    public static void main(String[] args) {
        long a1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }
        // 查看执行时间
        long a2 = System.currentTimeMillis();
        System.out.println("cost : " + (a2 - a1) + " ms");
        // 为了方便查看堆内存中对象个数, 线程sleep
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void alloc() {
        User user = new User();
    }

    static class User {

    }
}
