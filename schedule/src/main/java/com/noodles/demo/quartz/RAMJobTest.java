package com.noodles.demo.quartz;

import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @ClassName RAMJobTest
 * @Description 测试
 * @Author noodles
 * @Date 2021/2/26 15:31
 */
public class RAMJobTest {
    /**
     * 使用 Quartz 步骤：
     *          1， 创建 SchedulerFactory
     *          2， 创建 Scheduler
     *          3， 创建 JobDetail
     *          4， 创建 Trigger
     *          5， 注册到 Scheduler： scheduler.scheduleJob(jobDetail, trigger)
     *          6, 启动 Scheduler： scheduler.start()
     */
    @Test
    public void testExecute() throws SchedulerException, InterruptedException {
        // 创建 Scheduler 工厂
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // 从工厂中获取调度器实例
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(RAMJob.class)
                .withDescription("this is a ram job")
                .withIdentity("ramJob", "ramGroup")
                .build();
        // 创建 Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("ramTrigger", "ramTriggerGroup")
                .startAt(new Date())
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
        // 注册任务和定时器
        scheduler.scheduleJob(jobDetail, trigger);
        // 启动调度器
        scheduler.start();
        System.out.println("启动时间： " + new Date() + " " + Thread.currentThread().getName());
        Thread.sleep(6000);
        System.out.println("done");
    }
}
