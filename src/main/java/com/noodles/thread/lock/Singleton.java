package com.noodles.thread.lock;

/**
 * @ClassName Singleton
 * @Description 双重检验锁（Double-checked Locking)
 * @Author noodles
 * @Date 2021/1/19 11:30
 */
public class Singleton {
    private Singleton() {}

    private volatile static Singleton instance;

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
