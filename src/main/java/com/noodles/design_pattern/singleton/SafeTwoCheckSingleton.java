package com.noodles.design_pattern.singleton;

import java.io.Serializable;

/**
 * @ClassName SafeTwoCheckSingleton
 * @Description 线程安全双重校验锁
 * 参考链接： https://juejin.cn/post/6844904001796866055
 * @Author noodles
 * @Date 2021/2/24 14:21
 */
public class SafeTwoCheckSingleton implements Serializable {

    private static volatile SafeTwoCheckSingleton singleton;

    private SafeTwoCheckSingleton() {}

    public static SafeTwoCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (SafeTwoCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new SafeTwoCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
