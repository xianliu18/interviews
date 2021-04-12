package com.noodles.thread.lock;

/**
 * @ClassName CustomLockTest
 * @Description 自定义锁测试
 *      参考链接： https://tech.meituan.com/2019/12/05/aqs-theory-and-apply.html
 * @Author noodles
 * @Date 2021/2/8 11:17
 */
public class CustomLockTest {

    static int count = 0;
    static CustomLock customLock = new CustomLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    customLock.lock();
                    for (int i = 0; i < 10000; i++) {
                        count++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    customLock.unlock();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
