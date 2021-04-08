package com.noodles.collections.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName ListAddStatistics
 * @Description ArrayList 和 LinkedList 插入位置，花费时间比较
 *      参考链接：https://bugstack.cn/interview/2020/08/30/面经手册-第8篇-LinkedList插入速度比ArrayList快-你确定吗.html
 * @Author noodles
 * @Date 2021/4/8 16:47
 */
public class ListAddStatistics {
    @Test
    public void test_ArrayList_addFirst() {
        ArrayList<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(0, i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_addFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.addFirst(i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    /**
     * @Description 尾部插入
     *      ArrayList： 5224
     *      LinkedList： 7348
     */
    @Test
    public void test_ArrayList_addLast() {
        ArrayList<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_addLast() {
        LinkedList<Integer> list = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.addLast(i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_ArrayList_addCenter() {
        ArrayList<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(list.size() >> 1, i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_addCenter() {
        LinkedList<Integer> list = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(list.size() >> 1, i);
        }
    }
}
