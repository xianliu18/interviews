package com.noodles.collections.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MapHashDemo
 * @Description Map 的 hash 值，扩容比较
 *      参考链接： https://bugstack.cn/interview/2020/08/07/面经手册-第3篇-HashMap核心知识-扰动函数-负载因子-扩容链表拆分-深度学习.html
 * @Author noodles
 * @Date 2021/4/8 16:43
 */
public class MapHashDemo {

    @Test
    public void test_hashMap() {
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("jmdw");
        list.add("e4we");
        list.add("io98");
        list.add("nmhg");
        list.add("vfg6");
        list.add("gfrt");
        list.add("alpo");
        list.add("vfbh");
        list.add("bnhj");
        list.add("zuio");
        list.add("iu8e");
        list.add("yhjk");
        list.add("plop");
        list.add("dd0p");
        for (String key : list) {
            int hash = key.hashCode() ^ (key.hashCode() >>> 16);
            System.out.println("字符串: " + key + "\\tIdx(16)：" + ((16-1) & hash) + "\tBit值：" + Integer.toBinaryString(hash) + "-" + Integer.toBinaryString(hash & 16) + "\t\tIdx(32)：" + ((32 - 1) & hash));
            System.out.println(Integer.toBinaryString(key.hashCode()) + " " + Integer.toBinaryString(hash) + " " + Integer.toBinaryString((32 - 1) & hash));
        }
    }

}
