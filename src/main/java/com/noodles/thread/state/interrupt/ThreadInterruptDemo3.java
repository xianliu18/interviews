package com.noodles.thread.state.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 线程中断示例
 * @Author: noodles
 * @create: 2021-02-02 07:37
 */
public class ThreadInterruptDemo3 extends Thread {

    private boolean running;

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            System.out.println("I am working ...");
        }
    }

    public static void main(String[] args) {
        ThreadInterruptDemo3 myThread = new ThreadInterruptDemo3();
        myThread.setRunning(true);
        myThread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.interrupt();
    }
}
