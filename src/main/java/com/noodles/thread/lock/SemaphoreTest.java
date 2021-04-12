package com.noodles.thread.lock;

import java.util.concurrent.Semaphore;

/**
 * @Description: 信号量测试
 *      参考链接： https://bugstack.cn/interview/2020/11/18/面经手册-第18篇-AQS-共享锁-Semaphore-CountDownLatch-听说数据库连接池可以用到.html
 * @Author: noodles
 * @create: 2021-01-20 07:28
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, false);
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "进入，剩余可用数量为：" + semaphore.availablePermits());
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, "线程名称: " + i).start();
        }
    }
}
