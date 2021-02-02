package com.noodles.thread;

/**
 * @Description: 线程异常处理机制
 * @Author: noodles
 * @create: 2021-01-31 21:23
 */
public class ThreadExceptionDemo {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.println("出现异常了");
            System.out.println("线程名称: " + t.getName());
            System.out.println("异常信息: " + e.getMessage());
        });
        myThread.start();
        System.out.println("main run......");
        System.out.println("main run......");
        System.out.println("main run......");
        System.out.println("main run......");

        MyThread2 my2 = new MyThread2();
        my2.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        double i = 12 / 0;
    }

}

class MyThread2 extends Thread {
    @Override
    public void run() {
        try {
            Class.forName("HelloWorld");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("发生了一个异常");
        }
    }
}
