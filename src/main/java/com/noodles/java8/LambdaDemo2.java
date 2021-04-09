package com.noodles.java8;

import org.junit.Test;

/**
 * @ClassName LambdaDemo2
 * @Description Lambda 访问成员变量和静态变量
 * @Author noodles
 * @Date 2021/4/9 11:06
 */
public class LambdaDemo2 {
    // 静态变量
    static int outerStaticNum;
    // 成员变量
    int outerNum;

    @Test
    public void testScope() {
        IConverter<Integer, String> stringIConverter = (from) -> {
            // 对成员变量赋值
            outerNum = 23;
            return String.valueOf(from);
        };
        IConverter<Integer, String> stringIConverter2 = (from) -> {
            // 对静态变量赋值
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        System.out.println(stringIConverter.convert(64));
        System.out.println(stringIConverter.convert(22));
    }
}
