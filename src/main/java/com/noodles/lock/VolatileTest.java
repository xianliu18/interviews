package com.noodles.lock;

/**
 * @Description: volatile 测试
 *     参考连接: https://bugstack.cn/interview/2020/10/21/面经手册-第14篇-volatile-怎么实现的内存可见-没有-volatile-一定不可见吗.html
 * @Author: noodles
 * @create: 2021-01-18 22:53
 */
public class VolatileTest {
    public static void main(String[] args) {
        final VT vt = new VT();

        Thread thread01 = new Thread(vt, "thread01");
        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                vt.sign = true;
                System.out.println("vt.sign = true 通知 while(!sign)结束!");
            }
        }, "thread02");

        thread01.start();
        thread02.start();
    }
}

class VT implements Runnable {
    public volatile boolean sign = false;

    public void run() {
        while (!sign) {
        }
        System.out.println(Thread.currentThread().getName() + " 测试通过!");
    }
}
