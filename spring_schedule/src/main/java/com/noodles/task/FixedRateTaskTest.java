package com.noodles.task;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.FixedRateTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName FixedRateTaskTest
 * @Description 固定时间间隔示例
 * @Author noodles
 * @Date 2021/2/25 14:50
 */
public class FixedRateTaskTest {

    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.initialize();
        FixedRateTask fixedRateTask = new FixedRateTask(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("[%s] - FixedRateTask 触发...", dateFormat.format(LocalDateTime.now())));
        }, 5000, 1000);
        Date startTime = new Date(System.currentTimeMillis() + fixedRateTask.getInitialDelay());
        taskScheduler.scheduleAtFixedRate(fixedRateTask.getRunnable(), startTime, fixedRateTask.getInterval());
        Thread.sleep(Integer.MAX_VALUE);
    }

}
