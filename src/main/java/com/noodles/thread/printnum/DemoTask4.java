package com.noodles.thread.printnum;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:  A A A B B B C C C 打印
 * @Author: noodles
 * @create: 2021-05-09 17:49
 */
public class DemoTask4 {

    volatile int status = 1;

    List<Integer> tempList = Arrays.asList(1, 2, 3);

    public static void main(String[] args) {
        DemoTask4 t = new DemoTask4();

        A2 a = new A2(t);
        B2 b = new B2(t);
        C2 c = new C2(t);

        a.start();
        b.start();
        c.start();
    }
}

class A2 extends Thread {
    DemoTask4 t1;

    A2(DemoTask4 t) {
        this.t1 = t;
    }


    @Override
    public void run() {
        try {
            synchronized (t1) {
                for (int i = 0; i <= 10; i++) {
                    while (t1.status != 1) {
                        t1.wait();
                    }

                    System.out.println(t1.tempList.get(i % 3) + "=====> " + i);
                    t1.status = 2;
                    t1.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B2 extends Thread {
    DemoTask4 t2;

    B2(DemoTask4 t) {
        this.t2 = t;
    }


    @Override
    public void run() {
        try {
            synchronized (t2) {
                for (int i = 0; i <= 10; i++) {
                    while (t2.status != 2) {
                        t2.wait();
                    }

                    System.out.println(t2.tempList.get(i % 3) + "=====> " + i);
                    t2.status = 3;
                    t2.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class C2 extends Thread {
    DemoTask4 t3;

    C2(DemoTask4 t) {
        this.t3 = t;
    }


    @Override
    public void run() {
        try {
            synchronized (t3) {
                for (int i = 0; i <= 10; i++) {
                    while (t3.status != 3) {
                        t3.wait();
                    }

                    System.out.println(t3.tempList.get(i % 3) + "=====> " + i);
                    t3.status = 1;
                    t3.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}