package com.noodles.jvm.oom;

import java.nio.ByteBuffer;

/**
 * @ClassName DirectBufferMemoryDemo
 * @Description 直接引用  OutOfMemoryError: Direct buffer memory
 *
 * 参考链接：https://www.bilibili.com/video/BV1zb411M7NQ?p=84
 *
 * 启动参数：
 *   -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * @Author noodles
 * @Date 2021/1/11 14:44
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory:" + (sun.misc.VM.maxDirectMemory() / (double) 1024/ 1024) + " MB");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ByteBuffer bf = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
