package com.noodles.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @ClassName StreamDemo
 * @Description Stream 操作集合
 * @Author noodles
 * @Date 2021/4/9 11:18
 */
public class StreamDemo {

    List<String> strList = new ArrayList<>();

    @Before
    public void initList() {
        strList.add("aaa");
        strList.add("bbb");
        strList.add("aab");
        strList.add("aac");
        strList.add("ccc");
        strList.add("cabb");
        strList.add("cdee");
        strList.add("ddd");
        strList.add("dcd");
        strList.add("mmm");
        strList.add("amm");
    }

    /**
     * filter 使用
     */
    @Test
    public void test2() {
        strList.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
    }

    /**
     * sorted 使用
     */
    @Test
    public void test3() {
        strList.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
    }

    /**
     * map使用
     */
    @Test
    public void test4() {
        strList.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    /**
     * match 匹配
     */
    @Test
    public void test5() {
        // anyMatch
        boolean anyStartsWithA = strList.stream()
                                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println("anyMatch: " + anyStartsWithA);

        // allMatch
        boolean allStartsWithA = strList.stream()
                                        .allMatch((s) -> s.startsWith("a"));
        System.out.println("allMatch: " + allStartsWithA);
        // noneMatch
        boolean noneStartsWithZ = strList.stream().noneMatch((s) -> s.startsWith("z"));
        System.out.println("noneMatch: " + noneStartsWithZ);
    }

    /**
     * count 计数
     */
    @Test
    public void test6() {
        long startsWithB = strList.stream()
                                    .filter((s) -> s.startsWith("b"))
                                    .count();
        System.out.println(startsWithB);
    }

    /**
     * reduce
     */
    @Test
    public void test7() {
        Optional<String> reduced = strList.stream()
                                            .sorted()
                                            .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }

    /**
     * Sequential Sort: 944 ms
     */
    @Test
    public void sequentialSort() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            values.add(UUID.randomUUID().toString());
        }
        long start = System.currentTimeMillis();
        long count = values.stream().sorted().count();
        System.out.println("总数为：" + count);
        System.out.println("耗费时长: " + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Parallel Sort: 409 ms
     */
    @Test
    public void parallelSort() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            values.add(UUID.randomUUID().toString());
        }
        long start = System.currentTimeMillis();
        long count = values.parallelStream().sorted().count();
        System.out.println("总数为：" + count);
        System.out.println("耗费时长: " + (System.currentTimeMillis() - start) + " ms");
    }
}
