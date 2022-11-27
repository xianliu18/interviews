package com.noodles.thread.state;

/**
 * @description: WaitNotify 线程 wait 后，会释放锁
 * @author: liuxian
 * @date: 2022-11-27 22:43
 */
public class WaitNotifyDemo3 {

    static WaitNotifyDemo3 lock = new WaitNotifyDemo3();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (lock) {
                System.out.println("T1 start...");
                try {
                    lock.wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end...");
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (lock) {
                System.out.println("T2 start...");
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 end...");
            }
        });
        t1.start();
        t2.start();

        t1.join();
        // 模拟实现 join 方法
//        synchronized (t1) {
//            try {
//                t1.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        System.out.println("main end...");
    }
}
