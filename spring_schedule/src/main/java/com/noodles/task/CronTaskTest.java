package com.noodles.task;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.CronTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName CronTaskTest
 * @Description CronTask 示例
 *      参考链接： www.cnblogs.com/throwable/p/12616945.html
 * @Author noodles
 * @Date 2021/2/25 14:38
 */
public class CronTaskTest {

    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.initialize();
        CronTask cronTask = new CronTask(() -> {
            System.out.println(String.format("[%s] - CronTask触发...", dateFormat.format(LocalDateTime.now())));
        }, "*/5 * * * * ?");
        taskScheduler.schedule(cronTask.getRunnable(), cronTask.getTrigger());
        Thread.sleep(Integer.MAX_VALUE);
    }
}
