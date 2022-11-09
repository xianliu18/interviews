package com.noodles.thread.lock;

import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: https://zhuanlan.zhihu.com/p/139020914#:~:text=1%2CCountdownLatch适用于所有线程通过某一点后通知方法%2C而CyclicBarrier则适合让所有线程在同一点同时执行,2%2CCountdownLatch利用继承AQS的共享锁来进行线程的通知%2C利用CAS来进行--%2C而CyclicBarrier则利用ReentrantLock的Condition来阻塞和通知线程
 * @author: liuxian
 * @date: 2022-11-09 10:01
 */
@Slf4j
public class CountDownLatchDemo2 {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            final int times = i;
            new Thread(() -> {
                try {
                    log.info("子线程：[{}] 正在赶路~", Thread.currentThread().getName());
                    Thread.sleep(1000 * times);
                    log.info("子线程：[{}] 到公司门口了~", Thread.currentThread().getName());
                    latch.countDown();
                    // 子线程并没有因为调用 latch.countDown 而阻塞，会继续执行下面的代码，
                    // 只是通知计数器 -1
                    log.info("子线程：[{}] 开始工作了~", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            log.info("门卫迎接员工上班中...");
            latch.await();
            log.info("员工都来了，门卫去休息了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
