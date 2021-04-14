package com.noodles.jvm;

/**
 * @ClassName SafePointDemo
 * @Description 安全点示例
 *      参考链接： https://zhuanlan.zhihu.com/p/286110609
 * @Author noodles
 * @Date 2021/4/14 9:26
 */
public class SafePointDemo {
    static Thread t1 = new Thread(() -> {
       while(true) {
           long start = System.currentTimeMillis();
           try {
               Thread.sleep(1000L);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           long cost = System.currentTimeMillis() - start;
           (cost > 1010L ? System.err : System.out).printf("thread: %s, costs %d ms\n", Thread.currentThread().getName(), cost);
       }
    });

    static Thread t2 = new Thread(() -> {
       while (true) {
           for (int i = 1; i <= 1000000000; i++) {
               boolean b = 1.0 / i == 0;
           }

           try {
               Thread.sleep(10);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    });

    private static final int _50KB = 50 * 1024;

    static Thread t3 = new Thread(() -> {
       while (true) {
           try {
               Thread.sleep(5);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           byte[] bytes = new byte[_50KB];
       }
    });

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1500L);
        t2.start();
        t3.start();
    }
}
