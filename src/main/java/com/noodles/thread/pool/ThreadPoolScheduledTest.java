package com.noodles.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: ScheduledPool测试类
 * @Author: noodles
 * @create: 2021-01-21 07:27
 */
@Slf4j
public class ThreadPoolScheduledTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(() -> {
            log.info("3秒后开始执行");
        }, 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> {
            log.info("3秒后开始执行,以后每2秒执行一次");
        }, 3, 2, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(() -> {
            log.info("3秒开始执行,后续延迟2秒");
        }, 3, 2, TimeUnit.SECONDS);
    }
}
