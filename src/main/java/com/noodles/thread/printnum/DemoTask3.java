package com.noodles.thread.printnum;

/**
 * @Description:  A B C A B C A B C 打印
 *      参考链接: https://stackoverflow.com/questions/43176198/multithreading-in-java-to-print-abc-using-3-threads/51240847
 *       - https://blog.csdn.net/xiaokang123456kao/article/details/77331878
 * @Author: noodles
 * @create: 2021-05-09 17:42
 */
public class DemoTask3 {

    volatile int status = 1;

    public static void main(String[] args) {
        DemoTask3 t = new DemoTask3();

        A1 a = new A1(t);
        B1 b = new B1(t);
        C1 c = new C1(t);

        a.start();
        b.start();
        c.start();
    }

}

class A1 extends Thread {
    DemoTask3 t1;

    A1(DemoTask3 t) {
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

                    System.out.println("A ");
                    t1.status = 2;
                    t1.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B1 extends Thread {
    DemoTask3 t2;

    B1(DemoTask3 t) {
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

                    System.out.println("B ");
                    t2.status = 3;
                    t2.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class C1 extends Thread {
    DemoTask3 t3;

    C1(DemoTask3 t) {
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

                    System.out.println("C ");
                    t3.status = 1;
                    t3.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}