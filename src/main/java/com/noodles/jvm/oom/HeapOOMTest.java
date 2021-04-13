package com.noodles.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 堆溢出
 *      参考链接: https://segmentfault.com/a/1190000021424972
 *      VM Args: -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 * @Author: noodles
 * @create: 2021-04-13 21:57
 */
public class HeapOOMTest {

    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        List<byte[]> byteList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            byte[] bytes = new byte[2 * _1MB];
            byteList.add(bytes);
        }
    }
}
