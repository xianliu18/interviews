package com.noodles.java8;

import org.junit.Test;

/**
 * @Description:
 * @Author:
 * @create: 2021-01-25 21:20
 */
public class MyClass {

    @Test
    public void testConvert() {
        IConverter<Integer, String> converter = String::valueOf;
        String coverted = converter.convert(11);
        System.out.println(coverted);
    }
}
