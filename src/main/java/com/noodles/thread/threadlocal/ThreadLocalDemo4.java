package com.noodles.thread.threadlocal;

import org.junit.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @ClassName ThreadLocalDemo2
 * @Description ThreadLocal 散列算法
 *      参考链接： https://bugstack.cn/interview/2020/09/23/面经手册-第12篇-面试官-ThreadLocal-你要这么问-我就挂了.html
 * @Author noodles
 * @Date 2021/4/9 14:28
 */
public class ThreadLocalDemo4 {
    /**
     * 验证 哈希值黄金分割点 0x61c88647
     */
    @Test
    public void test01() {
        int temp = BigDecimal.valueOf(Math.pow(2, 32) * 0.6180339887).intValue();
        System.out.println(temp);
        // 十六进制
        System.out.println(Integer.toString(temp, 16));
    }

    /**
     * 验证 斐波那契（Fibonacci）散列法
     *      - 更好的散列，减少哈希碰撞
     */
    private static final int HASH_INCREMENT = 0x61c88647;

    @Test
    public void testFibonacciHash() {
        int hashCode = 0;
        for (int i = 0; i < 16; i++){
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            int idx = hashCode & 15;
            System.out.println("斐波那契散列：" + idx + "\t 普通散列：" + (String.valueOf(i).hashCode() & 15));
        }
    }

    @Test
    public void test_nextHashCode() throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < 5; i++){
            ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
            Field threadLocalHashCode = stringThreadLocal.getClass().getDeclaredField("nextHashCode");
            threadLocalHashCode.setAccessible(true);
            System.out.println("nextHashCode:" + threadLocalHashCode.get(stringThreadLocal));
        }
    }

    @Test
    public void test_threadLocalHashCode() throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < 5; i++){
            ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
            Field threadLocalHashCode = stringThreadLocal.getClass().getDeclaredField("threadLocalHashCode");
            threadLocalHashCode.setAccessible(true);
            System.out.println("stringThreadLocal:" + threadLocalHashCode.get(stringThreadLocal));
        }
    }
}
