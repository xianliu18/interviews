package com.noodles.jvm.reference;

import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;

/**
 * @ClassName WeakHashMapDemo
 * @Description weakHashMap
 * 参考链接：https://www.bilibili.com/video/BV1zb411M7NQ?p=76
 * @Author noodles
 * @Date 2021/1/11 13:43
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("==========================");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }
}
