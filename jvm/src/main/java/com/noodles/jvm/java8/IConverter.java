package com.noodles.jvm.java8;

@FunctionalInterface
public interface IConverter<F, T> {

    T convert(F from);

}
