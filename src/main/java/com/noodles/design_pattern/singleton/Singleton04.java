package com.noodles.design_pattern.singleton;

/**
 * @description: 单例模式，使用内部类
 * @author: liuxian
 * @date: 2022-11-23 19:11
 */
public class Singleton04 {

    private Singleton04() {}

    private static class SingletonHolder {
        private static Singleton04 instance = new Singleton04();
    }

    public static Singleton04 getInstance() {
        return SingletonHolder.instance;
    }

}
