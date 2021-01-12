package com.noodles.asm;

import java.util.Random;

/**
 * @ClassName JavaHeapSpaceDemo
 * @Description java 堆
 * @Author noodles
 * @Date 2021/1/11 14:24
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "hashMap";

        while (true) {
            str += str + new Random().nextInt(11111111) + new Random().nextInt(2222222);
            str.intern();
        }
    }
}
