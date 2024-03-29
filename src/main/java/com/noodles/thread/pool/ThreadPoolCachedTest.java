package com.noodles.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: CachedThreadPool测试
 * @Author: noodles
 * @create: 2021-01-20 23:06
 */
@Slf4j
public class ThreadPoolCachedTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i < 5; i++) {
            int groupId = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程名称：{}, 完成任务编号：{}", Thread.currentThread().getName(), groupId);
            });
        }
        executorService.shutdown();
    }

}
