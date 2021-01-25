package com.noodles.jvm.java8;

/**
 * @Description:
 * @Author:
 * @create: 2021-01-25 21:57
 */
public class MyConsumer<T> {

    public void accept(T obj) {
        Person person = (Person)obj;
        System.out.println("Hello, " + person.firstName);
    }
}
