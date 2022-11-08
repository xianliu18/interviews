package com.noodles.thread.lock.aqs;

import com.noodles.thread.lock.aqs.SyncLock;
import org.junit.Test;

/**
 * @ClassName LockTest
 * @Description 锁测试
 *      参考链接： https://bugstack.cn/interview/2020/11/11/面经手册-第17篇-码农会锁-ReentrantLock之AQS原理分析和实践使用.html
 * @Author noodles
 * @Date 2021/1/19 19:33
 */
public class SyncLockTest {

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
            lock.lock();
            try {
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
