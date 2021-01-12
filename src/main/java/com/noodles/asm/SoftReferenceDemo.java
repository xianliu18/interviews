package com.noodles.asm;

import java.lang.ref.SoftReference;

/**
 * @ClassName SoftReferenceDemo
 * @Description 软引用
 * @Author noodles
 * @Date 2021/1/11 12:12
 */
public class SoftReferenceDemo {
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());
    }

    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
//        System.gc();

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    public static void main(String[] args) {
        softRef_Memory_NotEnough();
    }
}
