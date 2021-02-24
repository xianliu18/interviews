package com.noodles.design_pattern.singleton;

/**
 * @ClassName UnSafeTwoCheckSingleton
 * @Description 线程不安全双重校验锁
 * 参考链接： https://juejin.cn/post/6844904001796866055
 * @Author noodles
 * @Date 2021/2/24 14:16
 */
public class UnSafeTwoCheckSingleton {

    private static UnSafeTwoCheckSingleton singleton;

    private UnSafeTwoCheckSingleton() {}

    public static UnSafeTwoCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (UnSafeTwoCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new UnSafeTwoCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
