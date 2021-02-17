package com.noodles.asm;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 软引用示例
 * @Author: noodles
 * 启动参数:
 *  -Xmx16m  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:NewSize=2m -XX:MaxNewSize=2m
 * @create: 2021-02-16 21:57
 */
public class SoftReferenceDemo2 {
    public static void main(String[] args) throws InterruptedException {
//        softReferenceEnough();
        softReferenceNotEnough();
    }

    private static void softReferenceEnough() throws InterruptedException {
        final int _1M = 1 * 1024 * 1024;
        List<SoftReference> list = new ArrayList<>();
        System.out.println("add 1m -1");
        list.add(new SoftReference(new byte[_1M]));
        System.out.println("add 1m -2");
        list.add(new SoftReference(new byte[_1M]));
        System.out.println("add 1m -3");
        list.add(new SoftReference(new byte[_1M]));
        System.gc();
        System.out.println("gc--");
        TimeUnit.SECONDS.sleep(1);
        list.stream().forEach(r -> System.out.println(r.get()));
    }

    private static void softReferenceNotEnough() throws InterruptedException {
        final int _8M = 8 * 1024 * 1024;
        List<SoftReference> list = new ArrayList<>();
        System.out.println("add 8m -1");
        list.add(new SoftReference(new byte[_8M]));
        System.out.println("add 8m -2");
        list.add(new SoftReference(new byte[_8M]));
        System.out.println("add 8m -3");
        list.add(new SoftReference(new byte[_8M]));
        list.stream().forEach(r -> System.out.println(r.get()));
    }
}
