package com.noodles.jvm.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 强引用示例
 * @Author: noodles
 *
 * -Xms: 等价于 -XX:InitialHeapSize
 * -Xmx: 等价于 -XX:MaxHeapSize
 * -Xss: 等价于 -XX:ThreadStackSize   单个线程栈的大小
 * -XX:MaxTenuringThreshold=15 设置垃圾最大年龄，默认为15
 *
 *
 * 启动参数:
 * -Xmx16m  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:NewSize=2m -XX:MaxNewSize=2m
 *
 * @create: 2021-02-16 21:51
 */
public class StrongReferenceDemo2 {
    public static void main(String[] args) {
        final int _8M = 8 * 1024 * 1024;
        List<byte[]> list = new ArrayList<>();
        System.out.println("add 8m -1");
        list.add(new byte[_8M]);
        System.out.println("add 8m -2");
        list.add(new byte[_8M]);
        list.stream().forEach(r -> System.out.println(r));
    }
}
