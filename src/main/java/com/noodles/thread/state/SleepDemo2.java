package com.noodles.thread.state;

/**
 * @Description: Yield示例
 *      参考连接: https://www.cnblogs.com/noteless/p/10443446.html
 * @Author: noodles
 * @create: 2021-02-03 08:24
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        // 模拟执行任务的第一阶段
        Thread stepOne = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": 第一阶段任务开始执行");

            try {
                Thread.sleep(3);
                System.out.println(Thread.currentThread().getName() + ": 第一阶段任务执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "firstStage");
        stepOne.start();

        // 模拟执行第二阶段
        Thread stepTwo = new Thread(() -> {
            while (!Thread.State.TERMINATED.equals(stepOne.getState())) {
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + ": 我在等待第一阶段任务执行结束");
            }

            System.out.println(Thread.currentThread().getName() + ": 第二阶段任务执行结束");

        }, "secondStage");
        stepTwo.start();
    }
}
