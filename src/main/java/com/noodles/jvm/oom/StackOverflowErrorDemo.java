package com.noodles.jvm.oom;

/**
 * @ClassName StackOverflowErrorDemo
 * @Description 栈溢出
 * 参考链接：https://www.bilibili.com/video/BV1zb411M7NQ?p=81
 * @Author noodles
 * @Date 2021/1/11 14:20
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
