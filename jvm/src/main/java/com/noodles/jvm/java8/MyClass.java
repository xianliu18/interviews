package com.noodles.jvm.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @Description:
 * @Author:
 * @create: 2021-01-25 21:25
 */
public class MyClass {

    @Test
    public void testConverter() {
        IConverter<Integer, String> converter = String::valueOf;
        String converted = converter.convert(11);
        System.out.println(converted);
    }

    @Test
    public void testSome() {
        Something something = new Something();

        IConverter<String, String> converter01 = s -> String.valueOf(s.charAt(0));
        IConverter<String, String> converter02 = something::startsWith;

        System.out.println(converter01.convert("java"));
        System.out.println(converter02.convert("java"));
    }

    @Test
    public void testPerson() {
        IPersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }

    @Test
    public void test12() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        Function<String, String> afterToStartsWith = backToString.andThen(new Something()::startsWith);
        String apply = afterToStartsWith.apply("123");
        System.out.println(apply);
    }

    @Test
    public void test14() {
        Consumer<Person> greeter01 = new Consumer<Person>(){
            @Override
            public void accept(Person person) {
                System.out.println("Hello, " + person.firstName);
            }
        };
        Consumer<Person> greeter02 = (p) -> System.out.println("Hello, " + p.firstName);
        greeter02.accept(new Person("Luke", "Skywalker"));
        Consumer<Person> greeter03 = new MyConsumer<Person>()::accept;
        greeter03.accept(new Person("Luke", "Skywalker"));
    }

    @Test
    public void test15() {
        Comparator<Person> comp1 = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Comparator<Person> comp2 = Comparator.comparing(p -> p.firstName);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        comp1.compare(p1, p2);
        comp2.reversed().compare(p1, p2);
    }

    @Test
    public void test25() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((key, value) -> System.out.println(value));
    }

    @Test
    public void test26() {
        Map<Integer, BeanA> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, new BeanA(i, "明明" + i, i + 20,"89021839021830912809" + i));
        }

        Stream<BeanB> beanBStream00 = map.values().stream().map(new Function<BeanA, BeanB>() {
            @Override
            public BeanB apply(BeanA beanA) {
                return new BeanB(beanA.getName(), beanA.getAge());
            }
        });

        Stream<BeanB> beanBStream01 = map.values().stream().map(beanA -> new BeanB(beanA.getName(), beanA.getAge()));
        beanBStream01.forEach(System.out::println);
    }

    @Test
    public void test30() {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));
    }
}
