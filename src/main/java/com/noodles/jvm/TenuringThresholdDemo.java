package com.noodles.jvm;

/**
 * @Description: 长期存活对象示例
 * @Author: noodles
 * @create: 2021-02-16 14:08
 */
public class TenuringThresholdDemo {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB / 4];

        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
