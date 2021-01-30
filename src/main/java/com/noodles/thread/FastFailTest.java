package com.noodles.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description: fail-fast 事件处理
 * @Author: noodles
 * @create: 2021-01-30 12:48
 */
public class FastFailTest {

    private static List<Integer> list = new ArrayList<>();
//    private static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // 同时启动两个线程对list进行操作
        new ThreadOne().start();
        new ThreadTwo().start();
    }

    private static class ThreadOne extends Thread {
        public void run() {
            Iterator<Integer> iter = list.iterator();
            while (iter.hasNext()) {
                int i = iter.next();
                System.out.println("ThreadOne 遍历: " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreadTwo extends Thread {
        public void run() {
            int i = 0;
            while (i < 6) {
                System.out.println("ThreadTwo run: " + i);
                if (i == 3) {
                    list.remove(i);
                }
                i++;
            }
        }
    }
}
