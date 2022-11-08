package com.noodles.thread.lock.reentrant.spinlock;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @description: CLHLock 测试类
 * @author: liuxian
 * @date: 2022-11-08 16:07
 */
@Slf4j
public class CLHLockDemo {

    private static final CLHLock lock = new CLHLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> test(), "Thread A").start();
//        new Thread(() -> test(), "Thread B").start();
//        new Thread(() -> test(), "Thread C").start();
//        new Thread(() -> test(), "Thread D").start();
        TimeUnit.SECONDS.sleep(60);
    }

    public static void test() {
        lock.lock();
        try {
            log.info(Thread.currentThread().getName() + "开始执行任务....");
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info(Thread.currentThread().getName() + "结束执行任务....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
