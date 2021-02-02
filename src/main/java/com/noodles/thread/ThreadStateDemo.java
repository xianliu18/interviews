package com.noodles.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 线程状态
 * @Author: noodles
 * @create: 2021-01-31 22:33
 */
public class ThreadStateDemo {

    public static void main(String[] args) {
        Thread myThread = new Thread() {
          @Override
          public void run() {
              super.run();
          }
        };

        myThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("current thread: " + Thread.currentThread().getName() + "    isAlive: " + Thread.currentThread().isAlive());

        System.out.println("myThread: " + myThread.getName() + "    isAlive: " + myThread.isAlive());
        System.out.println("myThread: " + myThread.getName() + "    state: " + myThread.getState());
    }

}
