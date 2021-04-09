package com.noodles.string;

import org.junit.Test;

/**
 * @ClassName StringStatistics
 * @Description StringBuilder, StringBuffer比较
 *      参考链接： https://bugstack.cn/interview/2020/09/17/面经手册-第11篇-StringBuilder-比-String-快-空嘴白牙的-证据呢.html
 * @Author noodles
 * @Date 2021/4/9 8:55
 */
public class StringStatistics {
    /***
     * @Description
     *     耗费时长： 1603050毫秒
     */
    @Test
    public void test_String() {
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 1000000; i++) {
            str += i;
        }
        System.out.println("String 耗时:" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    /***
     * @Description
     *     耗费时长： 5862毫秒
     */
    @Test
    public void test_StringBuilder() {
        long startTime = System.currentTimeMillis();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            str.append(i);
            System.out.println(i);
        }
        System.out.println("StringBuilder 耗时" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    /***
     * @Description
     *     耗费时长： 5461毫秒
     */
    @Test
    public void test_StringBuffer() {
        long startTime = System.currentTimeMillis();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            str.append(i);
            System.out.println(i);
        }
        System.out.println("StringBuffer 耗时:" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}
