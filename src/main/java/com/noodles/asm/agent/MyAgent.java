package com.noodles.asm.agent;

import java.lang.instrument.Instrumentation;

/**
 * @Description: 监控类入口
 * @Author: noodles
 * @create: 2021-01-06 22:20
 */
public class MyAgent {

    // JVM首先尝试在代理类上调用以下方法
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("This is my agent:" + agentArgs);
        MyMonitorTransformer monitor = new MyMonitorTransformer();
        inst.addTransformer(monitor);
    }

    // 如果代理类没有实现上面的方法,那么 JVM 将尝试调用该方法
    public static void premain(String agentArgs) {

    }
}
