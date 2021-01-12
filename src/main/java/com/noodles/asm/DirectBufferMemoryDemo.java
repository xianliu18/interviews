package com.noodles.asm;

import java.nio.ByteBuffer;

/**
 * @ClassName DirectBufferMemoryDemo
 * @Description 直接引用
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
