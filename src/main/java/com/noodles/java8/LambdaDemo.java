package com.noodles.java8;

/**
 * @ClassName LambdaDemo
 * @Description Lambda 访问局部变量
 *      参考链接： https://bugstack.cn/itstack-demo-any/2019/12/10/有点干货-Jdk1.8新特性实战篇(41个案例).html
 * @Author noodles
 * @Date 2021/4/9 11:03
 */
public class LambdaDemo {
    public static void main(String[] args) {
        int num = 1;
        IConverter<Integer, String> stringConverter = from -> String.valueOf(from + num);
        // num 是不可变值，不能改变
//        num = 3;
        String convert = stringConverter.convert(2);
        System.out.println(convert);
    }
}
