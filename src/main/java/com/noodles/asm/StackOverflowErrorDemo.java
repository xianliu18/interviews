package com.noodles.asm;

/**
 * @ClassName StackOverflowErrorDemo
 * @Description 栈溢出
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
