package com.noodles.thread.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @description: 测试 hash 函数
 * @author: liuxian
 * @date: 2022-11-28 09:48
 */
public class ThreadLocalDemo6 {

    public static final int _1MB = 1024 * 1024;

    // 创建时，初始化完成，final 保证后续不会变化
    public final int threadLocalHashCode = nextHashCode();

    // 因为是 static，类级别下共享
    private static AtomicInteger nextHashCode = new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    public static void main(String[] args) {
        ThreadLocal<byte[]> t = new ThreadLocal<>();
        byte[] bytes = new byte[1 * _1MB];
        for (int i = 0; i < 10; i++) {
            t.set(bytes);
        }
        return;
    }

    @Test
    public void test_idx() {
        ThreadLocalDemo6 t1 = new ThreadLocalDemo6();
        ThreadLocalDemo6 t2 = new ThreadLocalDemo6();
        ThreadLocalDemo6 t3 = new ThreadLocalDemo6();
        ThreadLocalDemo6 t4 = new ThreadLocalDemo6();

        System.out.println(t1.threadLocalHashCode & (16 - 1));
        System.out.println(t2.threadLocalHashCode & (16 - 1));
        System.out.println(t3.threadLocalHashCode & (16 - 1));
        System.out.println(t4.threadLocalHashCode & (16 - 1));
    }

}
