package com.noodles.jvm.oom;

import java.util.Random;

/**
 * @ClassName JavaHeapSpaceDemo
 * @Description java 堆 OutOfMemoryError: Java heap space
 *
 * 参考链接：https://www.bilibili.com/video/BV1zb411M7NQ?p=82
 *
 * 启动参数：
 * -Xms10m -Xmx10m
 *
 * @Author noodles
 * @Date 2021/1/11 14:24
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "hashMap";

        while (true) {
            str += str + new Random().nextInt(11111111) + new Random().nextInt(2222222);
            str.intern();
        }
    }
}
