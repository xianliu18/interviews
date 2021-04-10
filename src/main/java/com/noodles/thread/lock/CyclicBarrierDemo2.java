package com.noodles.thread.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: 循环屏障
 * @Author: noodles
 * @create: 2021-02-13 16:28
 */
public class CyclicBarrierDemo2 {

    static class PreTask implements Runnable {

        private String task;
        private CyclicBarrier cyclicBarrier;

        public PreTask(String task, CyclicBarrier cyclicBarrier) {
            this.task = task;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            // 假设总共三个关卡
            for (int i = 1; i < 4; i++) {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(String.format("关卡%d的任务%s完成", i, task));
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                cyclicBarrier.reset();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("本关卡所有前置任务完成,开始游戏...");
        });

        new Thread(new PreTask("加载地图数据", cyclicBarrier)).start();
        new Thread(new PreTask("加载人物数据", cyclicBarrier)).start();
        new Thread(new PreTask("加载背景音乐", cyclicBarrier)).start();
    }
}
