package com.noodles.jvm.gc;

import java.util.Random;

/**
 * @ClassName GCDemo
 * @Description GC 示例
 *
 * 启动命令:
 *   1, -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC    (DefNew + Tenured)
 *
 *   2, -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC     (ParNew + Tenured)
 *
 *   3, -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC    (PSYoungGen + ParOldGen)
 *
 *   3.1 -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC (PSYoungGen + ParOldGen)
 *
 *   3.2 -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags                       (PSYoungGen + ParOldGen)
 *
 *   4, -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC    (ParNew + concurrent mark-sweep)
 *
 *   5, -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 *
 * @Author noodles
 * @Date 2021/1/11 16:51
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("**********GCDemo hello");
        try {
            String str = "hashMap";
            while (true) {
                str += str + new Random().nextInt(11111111) + new Random().nextInt(22222222);
                str.intern();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
