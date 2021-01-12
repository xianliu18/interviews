package com.noodles.asm;

import java.sql.SQLOutput;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 测试用例
 * @Author: noodles
 * @create: 2021-01-06 08:39
 */
public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = obj1;
        obj1 = null;
        System.gc();
        System.out.println(obj2);
    }
}
