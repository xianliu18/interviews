package com.noodles.basic;

/**
 * @ClassName Disturb
 * @Description 扰动函数
 * @Author noodles
 * @Date 2021/1/14 19:11
 */
public class Disturb {
    public static int disturbHashIdx(String key, int size) {
        return (size - 1) & (key.hashCode() ^ (key.hashCode() >>> 16));
    }

    public static int hashIdx(String key, int size) {
        return (size - 1) & key.hashCode();
    }
}
