package com.noodles.thread.lock.synchronizeddemo;

/**
 * @ClassName AtomicTest
 * @Description 原子性测试
 *      参考链接: https://bugstack.cn/interview/2020/10/28/面经手册-第15篇-码农会锁-synchronized-解毒-剖析源码深度分析.html
 *
 *      反编译: javap -v -p AtomicTest
 * @Author noodles
 * @Date 2021/1/19 10:53
 */
public class AtomicTest {

    private static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    add();
                }
            });
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println(counter);
    }

    /**
     * 同步代码块: 通过指令 monitorenter 和 monitorexit 来实现
     */
    public static void add() {
        synchronized (AtomicTest.class) {
            counter++;
        }
    }

    /**
     * 同步方法: 并没有通过指令monitorenter和monitorexit来完成
     *          相对于普通方法，其常量池中多了ACC_SYNCHRONIZED标示符。
     *          当方法调用时，调用指令将会检查方法的 ACC_SYNCHRONIZED 访问标志是否被设置，如果设置了，
     *          执行线程将先获取monitor，获取成功之后才能执行方法体，方法执行完后再释放monitor。
     *          参考连接: https://www.cnblogs.com/paddix/p/5367116.html
     */
    public synchronized void add(int num) {
        int sum = 0;
        sum += num;
    }
}
