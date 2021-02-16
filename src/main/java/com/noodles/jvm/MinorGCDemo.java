package com.noodles.jvm;

/**
 * @Description: Minor GC 示例
 * @Author: noodles
 * @create: 2021-02-16 13:59
 */
public class MinorGCDemo {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
