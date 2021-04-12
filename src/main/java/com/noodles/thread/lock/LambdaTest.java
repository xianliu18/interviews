package com.noodles.thread.lock;

import java.util.function.Consumer;

/**
 * @Description: invokedynamic 测试
 *      参考链接： https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html
 *
 *      反编译：javap -v -p LambdaTest
 *
 *      Unsafe 类相关
 * @Author: noodles
 * @create: 2021-02-06 23:34
 */
public class LambdaTest {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("lambda");
    }
}
