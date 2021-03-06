package com.noodles.redis;

import org.junit.Test;

/**
 * @Description: 测试类
 * @Author: noodles
 * @create: 2021-03-06 13:52
 */
public class SimpleCacheTest {

    @Test
    public void test() {
        SimpleCache<Integer, Integer> cache = new SimpleCache<>(3);

        for (int i = 0; i < 10; i++) {
            cache.save(i, i * i);
        }

        System.out.println("插入 10 个键值对后, 缓存内容: ");
        System.out.println(cache + "\n");

        System.out.println("访问键值为7的节点后, 缓存内容: ");
        cache.getOne(7);
        System.out.println(cache + "\n");

        System.out.println("插入键值为 1 的键值对后, 缓存内容: ");
        cache.save(1, 1);
        System.out.println(cache);
    }
}
