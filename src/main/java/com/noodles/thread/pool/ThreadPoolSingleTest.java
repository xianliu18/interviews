package com.noodles.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: SingleThread测试
 * @Author: noodles
 * @create: 2021-01-20 23:02
 */
@Slf4j
public class ThreadPoolSingleTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 5; i++) {
            int groupId = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程名称：{} -----> 第 {} 组任务, 第 {} 次执行完成", Thread.currentThread().getName(), groupId);
            });
        }
        executorService.shutdown();
    }

}
