package com.noodles.demo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @ClassName RAMJob
 * @Description 任务
 * @Author noodles
 * @Date 2021/2/26 15:30
 */
public class RAMJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello Quartz: " + new Date() + " " + Thread.currentThread().getName());
    }
}
