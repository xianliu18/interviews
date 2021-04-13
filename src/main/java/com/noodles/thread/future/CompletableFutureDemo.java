package com.noodles.thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureDemo
 * @Description CompletableFuture 示例
 *      参考链接： https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650
 * @Author noodles
 * @Date 2021/4/13 15:55
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建异步执行任务
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureDemo::fetchPrice);
        // 如果执行成功
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则 CompletableFuture 默认使用的线程池会立刻关闭
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
