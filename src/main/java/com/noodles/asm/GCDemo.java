package com.noodles.asm;

import java.util.Random;

/**
 * @ClassName GCDemo
 * @Description GC 示例
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
