package com.noodles.aop.test;

import com.noodles.thread.lock.SyncLock;
import org.junit.Test;

/**
 * @ClassName LockTest
 * @Description 锁测试
 * @Author noodles
 * @Date 2021/1/19 19:33
 */
public class LockTest {

    @Test
    public void test_SyncLock() throws InterruptedException {
        final SyncLock lock = new SyncLock();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(200);
            new Thread(new TestLock(lock), String.valueOf(i)).start();
        }
        Thread.sleep(100000);
    }

    static class TestLock implements Runnable {

        private SyncLock lock;

        public TestLock(SyncLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                Thread.sleep(1000);
                System.out.println(String.format("Thread %s Completed", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
