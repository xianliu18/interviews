package com.noodles.jvm.java8;

@FunctionalInterface
public interface IPersonFactory<P extends Person> {

    P create(String fristName, String lastName);

}
