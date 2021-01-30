package com.noodles.lock;

/**
 * @Description: volatile 测试
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
