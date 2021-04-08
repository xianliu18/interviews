package com.noodles.collections.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @ClassName ForTimeStatics
 * @Description For 遍历时间统计
 * @Author noodles
 * @Date 2021/4/8 16:41
 */
public class ForTimeStatistics {

    private LinkedList<Integer> list = new LinkedList<>();
    private int xx = 0;

    /**
     * @Description 初始化链表数组
     */
    @Before
    public void init() {
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
    }

    /**
     * @Description 普通for循环，耗时：2980440  大约50分钟
     */
    @Test
    public void test_LinkedList_for0() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            xx += list.get(i);
            System.out.println(i);
        }
        System.out.println("for0 耗时：" + (System.currentTimeMillis() - startTime));
    }

    /**
     * @Description 增强for循环，耗时：5334
     */
    @Test
    public void test_LinkedList_for1() {
        long startTime = System.currentTimeMillis();
        for (Integer itr : list) {
            xx += itr;
            System.out.println(itr);
        }
        System.out.println("for1 耗时：" + (System.currentTimeMillis() - startTime));
    }

    /**
     * @Description Iterator遍历，耗时：5149
     */
    @Test
    public void test_LinkedList_Iterator() {
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            Integer next = iter.next();
            xx += next;
            System.out.println(next);
        }
        System.out.println("iterator 耗时：" + (System.currentTimeMillis() - startTime));
    }

    /**
     * @Description forEach循环，耗时：5245
     */
    @Test
    public void test_LinkedList_forEach() {
        long startTime = System.currentTimeMillis();
        list.forEach(integer -> {
            xx += integer;
            System.out.println(integer);
        });
        System.out.println("forEach 耗时：" + (System.currentTimeMillis() - startTime));
    }

    /**
     * @Description Stream流，耗时：5261
     */
    @Test
    public void test_LinkedList_stream() {
        long startTime = System.currentTimeMillis();
        list.stream().forEach(integer -> {
            xx += integer;
            System.out.println(integer);
        });
        System.out.println("Stream 耗时：" + (System.currentTimeMillis() - startTime));
    }
}
