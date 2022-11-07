package com.noodles.thread.state;

import org.junit.Test;

/**
 * @description: sleep 示例
 * @author: liuxian
 * @date: 2022-11-07 10:21
 */
public class SleepDemo {
    /**
     * 参考链接: https://www.cnblogs.com/noteless/p/10443446.html
     */
    @Test
    public void test_TimedWaiting2() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程状态:" + thread.getState());
            if (Thread.State.TERMINATED.equals(thread.getState())) {
                System.out.println("线程状态: " + thread.getState());
                break;
            }
        }
    }
}
