package com.noodles.thread.threadcreate;

/**
 * @Description: 使用Runnable实例对象构造
 * @Author: noodles
 * @create: 2021-01-31 22:04
 */
public class MyThreadTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running...");
    }

    public static void main(String[] args) {
        // 定义一个可执行的任务
        MyThreadTask task = new MyThreadTask();

        // 将任务通过构造方法注入到Thread中,并且调用start方法
        new Thread(task).start();
    }
}
