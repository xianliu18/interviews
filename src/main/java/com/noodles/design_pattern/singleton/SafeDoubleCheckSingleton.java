package com.noodles.design_pattern.singleton;

import java.io.Serializable;

/**
 * @ClassName SafeDoubleCheckSingleton
 * @Description 线程安全双重校验锁
 * 参考链接： https://juejin.cn/post/6844904001796866055
 * @Author noodles
 * @Date 2021/2/24 14:21
 */
public class SafeDoubleCheckSingleton implements Serializable {

    private static volatile SafeDoubleCheckSingleton singleton;

    private SafeDoubleCheckSingleton() {}

    public static SafeDoubleCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (SafeDoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new SafeDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
