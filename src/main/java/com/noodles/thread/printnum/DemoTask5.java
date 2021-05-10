package com.noodles.thread.printnum;

/**
 * @Description: 三个线程交替打印 1 2 3, 再循环10次
 *      参考链接: https://gist.github.com/wqhyw/e94f98a22c843e77fc2dab1128c9a3ec
 * @Author: noodles
 * @create: 2021-05-10 14:58
 */
public class DemoTask5 {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Printer(1, 10));
        Thread b = new Thread(new Printer(2, 10));
        Thread c = new Thread(new Printer(3, 10));

        c.start();
        b.start();
        a.start();

        b.join();
        c.join();
        a.join();
    }

}

class Printer implements Runnable {

    private int counter;

    private final int seq;

    private static volatile int status = 0;

    Printer(int seq, int counter) {
        this.seq = seq;
        this.counter = counter;
    }

    @Override
    public void run() {
        int i = 0;
        while (counter > 0) {
            if (status % 3 == seq - 1) {
                System.out.println("Thread-" + seq + " => " + (i + 1));
                i = (i + 1) % 3;
                status++;
                if (i == 0) {
                    counter--;
                }
            }
        }
    }
}
