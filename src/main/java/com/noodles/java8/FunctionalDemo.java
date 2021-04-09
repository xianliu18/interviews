package com.noodles.java8;

import org.junit.Test;

/**
 * @Description: 函数式接口示例
 *      参考链接： https://bugstack.cn/itstack-demo-any/2019/12/10/有点干货-Jdk1.8新特性实战篇(41个案例).html
 * @Author: noodles
 * @create: 2021-01-25 21:20
 */
public class FunctionalDemo {
    
    /**
     * @Description 传统方式
     */
    @Test
    public void testConvert01() {
        IConverter<String, Integer> converter01 = new IConverter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return Integer.valueOf(from);
            }
        };
        System.out.println(converter01.convert("22"));
    }

    /**
     * @Description 方式二
     */
    @Test
    public void testConvert02() {
        IConverter<String, Integer> converter02 = (from) -> {
          return Integer.valueOf(from);
        };
        System.out.println(converter02.convert("22"));
    }

    /**
     * @Description 方式三
     */
    @Test
    public void testConvert03() {
        IConverter<String, Integer> converter02 = (from) -> Integer.valueOf(from);
        System.out.println(converter02.convert("22"));
    }

    /**
     * @Description 方式四
     */
    @Test
    public void testConvert04() {
        IConverter<String, Integer> converter02 = Integer::valueOf;
        System.out.println(converter02.convert("22"));
    }

    @Test
    public void testConvert05() {
        Something something = new Something();
        IConverter<String, String> converter01 = s -> String.valueOf(s.charAt(0));
        IConverter<String, String> converter02 = something::startsWith;
        System.out.println(converter01.convert("Java"));
        System.out.println(converter02.convert("Java"));
    }

    @Test
    public void testConvert() {
        IConverter<Integer, String> converter = String::valueOf;
        String coverted = converter.convert(11);
        System.out.println(coverted);
    }
}

class Something {
    public String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}
