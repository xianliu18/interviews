package com.noodles.lock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: CountDownLatch 示例
 * @Author: noodles
 * @create: 2021-02-13 16:20
 */
public class CountDownLatchDemo {

    // 定义前置任务线程
    static class PreTask implements Runnable {

        private String task;
        private CountDownLatch countDownLatch;

        public PreTask(String task, CountDownLatch countDownLatch) {
            this.task = task;
            this.countDownLatch = countDownLatch;
        }


        @Override
        public void run() {
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(100));
                System.out.println(task + " - 任务完成");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 假设有三个模块需要加载
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // 主任务
        new Thread(() -> {
            try {
                System.out.println("等待数据加载...");
                System.out.println(String.format("还有%d个前置任务", countDownLatch.getCount()));
                countDownLatch.await();
                System.out.println("数据加载完成,正式开始游戏!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 前置任务
        new Thread(new PreTask("加载地图数据", countDownLatch)).start();
        new Thread(new PreTask("加载人物模型", countDownLatch)).start();
        new Thread(new PreTask("加载背景音乐", countDownLatch)).start();
    }
}
