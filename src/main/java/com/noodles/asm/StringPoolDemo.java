package com.noodles.asm;

/**
 * @ClassName StringPoolDemo
 * @Description 字符串常量池
 * @Author noodles
 * @Date 2021/1/12 9:53
 */
public class StringPoolDemo {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }
}
