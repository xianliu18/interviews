package com.noodles.thread;

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
                for (int j = 1; j < 5; j++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("第 {} 组任务,第 {} 次执行完成", groupId, j);
                }
            });
        }
    }

}
