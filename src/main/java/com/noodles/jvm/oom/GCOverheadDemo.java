package com.noodles.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GCOverheadDemo
 * @Description GC 异常示例 OutOfMemoryError: GC overhead limit exceeded
 *
 * 参考链接：https://www.bilibili.com/video/BV1zb411M7NQ?p=83
 *
 * 启动参数：
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * @Author noodles
 * @Date 2021/1/11 14:31
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

//        ByteBuffer.allocateDirect();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("***************i:" + i);
            e.printStackTrace();
            throw e;
        }
    }
}
