package com.noodles.jvm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName JvmThread
 * @Description 一个线程OOM后，其他线程还能运行么？
 *      参考链接：https://mp.weixin.qq.com/s/HFiy5_z-pN_HlRTmj7s7qQ
 *
 *      JVM 启动参数：-Xms16m -Xmx32m
 *
 * @Author noodles
 * @Date 2021/4/7 9:48
 */
public class JvmThread {
    public static void main(String[] args) {
        // 线程一
        new Thread(() -> {
            List<byte[]> list = new ArrayList<>();
            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "===");
                byte[] b = new byte[1024 * 1024 * 1];
                list.add(b);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 线程二
        new Thread(() -> {
            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "===");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
