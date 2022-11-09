package com.noodles.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: Condition 示例
 *      参考链接： https://www.cnblogs.com/wang-meng/p/12816829.html
 * @Author: noodles
 * @create: 2021-02-07 23:02
 */
@Slf4j
public class ConditionTest2 {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                log.info("{} 加锁成功，准备执行任务~", Thread.currentThread().getName());
                TimeUnit.MILLISECONDS.sleep(1000);
                log.info("{} 执行await即将被挂起....", Thread.currentThread().getName());
                condition.await();
                log.info("{} 被唤醒成功!", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info("{} 准备释放锁！", Thread.currentThread().getName());
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                log.info("{} 加锁成功, 准备执行任务", Thread.currentThread().getName());
                TimeUnit.MILLISECONDS.sleep(1000);
                log.info("{} 准备唤醒其他线程", Thread.currentThread().getName());
                condition.signal();
                log.info("{} 继续执行剩下的任务", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info("{} 准备释放锁！", Thread.currentThread().getName());
                lock.unlock();
            }
        }).start();
    }
}
