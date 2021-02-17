package com.noodles.asm;

import java.lang.ref.WeakReference;

/**
 * @ClassName WeakReferenceDemo
 * @Description 弱引用
 * @Author noodles
 * 启动参数:
 *  -Xmx16m  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:NewSize=2m -XX:MaxNewSize=2m
 * @Date 2021/1/11 12:20
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("====================");
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
