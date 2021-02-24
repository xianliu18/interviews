package com.noodles.design_pattern.singleton;

import java.io.Serializable;

/**
 * @ClassName SafeTwoCheckSingleton2
 * @Description 防范序列化破坏单例
 * 参考链接： https://blog.csdn.net/yunfeng482/article/details/91406615
 * @Author noodles
 * @Date 2021/2/24 14:24
 */
public class SafeTwoCheckSingleton2 implements Serializable {

    private static volatile SafeTwoCheckSingleton2 singleton;

    private SafeTwoCheckSingleton2() {}

    public static SafeTwoCheckSingleton2 getSingleton() {
        if (singleton == null) {
            synchronized (SafeTwoCheckSingleton2.class) {
                if (singleton == null) {
                    singleton = new SafeTwoCheckSingleton2();
                }
            }
        }
        return singleton;
    }

    private Object readResolve() {
        return singleton;
    }
}
