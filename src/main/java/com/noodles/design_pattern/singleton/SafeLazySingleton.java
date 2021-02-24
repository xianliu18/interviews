package com.noodles.design_pattern.singleton;

/**
 * @ClassName SafeLazySingleton
 * @Description 线程安全的懒汉式
 * @Author noodles
 * @Date 2021/2/24 14:14
 */
public class SafeLazySingleton {
    private static SafeLazySingleton safeLazySingleton;

    private SafeLazySingleton() {}

    public static synchronized SafeLazySingleton getSafeLazySingleton() {
        if (safeLazySingleton == null) {
            safeLazySingleton = new SafeLazySingleton();
        }
        return safeLazySingleton;
    }
}
