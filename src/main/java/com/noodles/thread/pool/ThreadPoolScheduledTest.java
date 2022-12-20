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
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.schedule(() -> {
            log.info("3秒后开始执行，仅执行一次!");
        }, 3, TimeUnit.SECONDS);

        // sheduleAtFixedRate 是以上一个任务开始的时间计时，period 时间过去后，
        // 检测上一个任务是否执行完毕，如果上一个任务执行完毕，则当前任务立即执行；
        // 如果上一个任务没有执行完毕，则需要等待上一个任务执行完毕后，立即执行

        // 3秒后开始执行,以后每2秒执行一次
        executorService.scheduleAtFixedRate(() -> {
            log.info("scheduleAtFixedRate 开始执行~");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("scheduleAtFixedRate 执行结束~");
        }, 3, 2, TimeUnit.SECONDS);

        // sheduleWithFixedDelay: 是以上一个任务结束时开始计时，delay 时间过去后，立即执行

        // 3秒开始执行,后续延迟2秒
        executorService.scheduleWithFixedDelay(() -> {
            log.info("scheduleWithFixedDelay 开始执行~");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("scheduleWithFixedDelay 执行结束~");
        }, 3, 2, TimeUnit.SECONDS);
    }
}
