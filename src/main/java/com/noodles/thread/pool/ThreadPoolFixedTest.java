package com.noodles.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: FixedThreadPool测试
 *      参考链接： https://bugstack.cn/interview/2020/12/16/面经手册-第22篇-线程池的介绍和使用-以及基于jvmti设计非入侵监控.html
 * @Author: noodles
 * @create: 2021-01-20 23:00
 */
@Slf4j
public class ThreadPoolFixedTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 6; i++) {
            int groupId = i;
            executorService.execute(() -> {
                for (int j = 1; j < 5; j++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("第 {} 组任务, 第 {} 次执行完成", groupId, j);
                }
            });
        }
        executorService.shutdown();
    }
}
