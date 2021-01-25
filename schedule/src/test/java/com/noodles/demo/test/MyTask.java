package com.noodles.demo.test;

import com.noodles.demo.DemoTask;

import java.text.ParseException;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Description: 自定义任务
 * @Author: noodles
 * @create: 2021-01-24 12:44
 */
public class MyTask {

    public static void main(String[] args) throws Exception {

        DemoTask demoTask = new DemoTask();

        // 定义了 执行的内容
        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        methodInvokingJobDetailFactoryBean.setTargetObject(demoTask);
        methodInvokingJobDetailFactoryBean.setTargetMethod("execute");
        methodInvokingJobDetailFactoryBean.setConcurrent(true);
        methodInvokingJobDetailFactoryBean.setName("demoTask");
        methodInvokingJobDetailFactoryBean.afterPropertiesSet();

        // 定义了 执行的计划
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("0/5 * * * * ?");
        cronTriggerFactoryBean.setName("demoTask");
        cronTriggerFactoryBean.afterPropertiesSet();

        // 定义了 执行的功能
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.afterPropertiesSet();

        schedulerFactoryBean.start();

        // 暂停住
        System.in.read();
    }
}
