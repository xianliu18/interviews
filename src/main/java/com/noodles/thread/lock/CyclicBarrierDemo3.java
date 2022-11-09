package com.noodles.thread.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: https://zhuanlan.zhihu.com/p/139020914#:~:text=1%2CCountdownLatch适用于所有线程通过某一点后通知方法%2C而CyclicBarrier则适合让所有线程在同一点同时执行,2%2CCountdownLatch利用继承AQS的共享锁来进行线程的通知%2C利用CAS来进行--%2C而CyclicBarrier则利用ReentrantLock的Condition来阻塞和通知线程
 * @author: liuxian
 * @date: 2022-11-09 09:53
 */
@Slf4j
public class CyclicBarrierDemo3 {

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10, ()->{
            log.info("\n\n所有人都准备好了，裁判发枪.....\n");
        });

        for (int i = 0; i < 10; i++) {
            final int times = i;
            new Thread(()->{
                try {
                    log.info("子线程：[{}] 正在准备", Thread.currentThread().getName());
                    Thread.sleep(1000 * times);
                    log.info("子线程：[{}] 准备好了", Thread.currentThread().getName());
                    cyclicBarrier.await();
                    log.info("子线程：[{}] 开始跑了", Thread.currentThread().getName());
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
