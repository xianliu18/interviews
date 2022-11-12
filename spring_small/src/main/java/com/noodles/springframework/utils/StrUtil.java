package com.noodles.springframework.utils;

/**
 * @description: 字符串工具
 * @author: liuxian
 * @date: 2022-11-12 10:57
 */
public class StrUtil {

    /**
     * 将首字母小写
     */
    public static String lowerFirstChar(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
