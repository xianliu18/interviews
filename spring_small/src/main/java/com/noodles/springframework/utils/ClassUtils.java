package com.noodles.springframework.utils;

/**
 * @description: 工具
 * @author: liuxian
 * @date: 2022-11-11 18:24
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            throw new RuntimeException("初始化 ClassLoader 异常！");
        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
