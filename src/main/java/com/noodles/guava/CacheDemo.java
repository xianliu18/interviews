package com.noodles.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * @Description: 缓存示例
 *      参考链接: https://juejin.cn/post/6844903660653117447
 * @Author: noodles
 * @create: 2021-04-17 20:47
 */
public class CacheDemo {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(30L, TimeUnit.MILLISECONDS)
                .expireAfterAccess(30L, TimeUnit.MILLISECONDS)
                .refreshAfterWrite(20L, TimeUnit.MILLISECONDS)
                .weakKeys()
                .build(createCacheLoader());
        System.out.println(cache.get("hello"));
        cache.put("hello1", "我是hello1");
        System.out.println(cache.get("hello1"));
        cache.put("hello1", "我是hello2");
        System.out.println(cache.get("hello1"));

    }

    @Test
    public void testExpire() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(5, TimeUnit.MILLISECONDS)
                .concurrencyLevel(1)
                .build();
        cache.put("hello1", "我是hello1");
        cache.put("hello2", "我是hello2");
        cache.put("hello3", "我是hello3");
        cache.put("hello4", "我是hello4");
        // 至少睡眠 5ms
        Thread.sleep(5);
        System.out.println(cache.size());
        cache.put("hello5", "我是hello5");
        System.out.println(cache.size());
    }

    public static CacheLoader<String, String> createCacheLoader() {
     return new CacheLoader<String, String>() {
         @Override
         public String load(String key) throws Exception {
             return key;
         }
     };
    }


}
