package com.noodles.thread.threadlocal;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ThreadLocalDemo1
 * @Description ThreadLocal 说明：
 *      1，ThreadLocalDemo1: ThreadLocal 线程安全使用
 *      2，ThreadLocalDemo2： ThreadLocal 用作线程局部变量
 *      3，ThreadLocalDemo3： ThreadLocal 中的弱引用
 *      2, ThreadLocalDemo4: ThreadLocalMap的Hash算法
 *      3, new ThreadLocal<>().set("aaa");  四种情况
 *      4, 启发式清理： cleanSomeSlots(int i, int n)
 *         探测式清理： expungeStaleEntries()
 *      5，InheritableThreadLocalDemo
 *      6, Netty FastThreadLocal 与 原生 ThreadLocal 性能比较
 *      7，ThreadLocalDemo5： TransmittableThreadLocal 与 原生 InheritableThreadLocal 性能比较
 * @Author noodles
 * @Date 2021/4/9 14:23
 */
public class ThreadLocalDemo1 {
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    @Test
    public void testNotSafe() {
        notSafe();
    }

    @Test
    public void testSafe() {
        safeMethod();
    }

    public static void notSafe() {
        while (true) {
            new Thread(() -> {
                String dateStr = f.format(new Date());
                try {
                    Date parseDate = f.parse(dateStr);
                    String dateStrCheck = f.format(parseDate);
                    boolean equals = dateStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(equals + " " + dateStr + " " + dateStrCheck);
                        Thread.sleep(10000);
                    } else {
                        System.out.println(equals);
                    }
                } catch (ParseException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void safeMethod() {
        while (true) {
            new Thread(() -> {
                String dateStr = threadLocal.get().format(new Date());
                try {
                    Date parseDate = threadLocal.get().parse(dateStr);
                    String dateStrCheck = threadLocal.get().format(parseDate);
                    boolean  equals = dateStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(dateStr + " !=" + dateStrCheck);
                        Thread.sleep(100);
                    } else {

                        System.out.println(equals);
                    }
                } catch (ParseException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
