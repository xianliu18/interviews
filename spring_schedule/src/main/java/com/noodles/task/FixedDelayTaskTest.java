package com.noodles.task;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.FixedDelayTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName FixedDelayTaskTest
 * @Description FixedDelayTask 示例
 * @Author noodles
 * @Date 2021/2/25 14:43
 */
public class FixedDelayTaskTest {

    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.initialize();
        FixedDelayTask fixedDelayTask = new FixedDelayTask(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("[%s] - FixedDelayTask 触发...", dateFormat.format(LocalDateTime.now())));
        }, 5000, 1000);
        Date startTime = new Date(System.currentTimeMillis() + fixedDelayTask.getInitialDelay());
        taskScheduler.scheduleWithFixedDelay(fixedDelayTask.getRunnable(), startTime, fixedDelayTask.getInterval());
        Thread.sleep(Integer.MAX_VALUE);
    }

}
