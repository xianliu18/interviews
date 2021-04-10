package com.noodles.thread.lock;

import java.util.function.Consumer;

/**
 * @Description: invokedynamic 测试
 * @Author: noodles
 * @create: 2021-02-06 23:34
 */
public class LambdaTest {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("lambda");
    }
}
