package com.noodles.design_pattern.singleton;

import java.io.Serializable;

/**
 * @ClassName SafeDoubleCheckSingleton2
 * @Description 防范序列化破坏单例
 * 参考链接： https://blog.csdn.net/yunfeng482/article/details/91406615
 * @Author noodles
 * @Date 2021/2/24 14:24
 */
public class SafeDoubleCheckSingleton2 implements Serializable {

    private static volatile SafeDoubleCheckSingleton2 singleton;

    private SafeDoubleCheckSingleton2() {}

    public static SafeDoubleCheckSingleton2 getSingleton() {
        if (singleton == null) {
            synchronized (SafeDoubleCheckSingleton2.class) {
                if (singleton == null) {
                    singleton = new SafeDoubleCheckSingleton2();
                }
            }
        }
        return singleton;
    }

    private Object readResolve() {
        return singleton;
    }
}
