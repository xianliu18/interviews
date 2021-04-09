package com.noodles.string;

/**
 * @ClassName StringDemo
 * @Description String + 反编译查看
 *      编译命令：   javac -encoding UTF-8 StringDemo.java
 *      反编译命令： javap -c StringDemo.class
 * @Author noodles
 * @Date 2021/4/9 9:11
 */
public class StringDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 1000000; i++) {
            str += i;
        }
        System.out.println("String 耗时:" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}
