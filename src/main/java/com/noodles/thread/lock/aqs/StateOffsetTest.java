package com.noodles.thread.lock.aqs;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName StateOffsetTest
 * @Description stateOffset 偏移量的值  16
 *      参考链接： https://bugstack.cn/interview/2020/11/11/面经手册-第17篇-码农会锁-ReentrantLock之AQS原理分析和实践使用.html
 * @Author noodles
 * @Date 2021/4/12 10:01
 */
public class StateOffsetTest {

    @Test
    public void test_stateOffset() throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = getUnsafeInstance();
        long state = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("state"));
        System.out.println(state);
    }

    private static Unsafe getUnsafeInstance() throws SecurityException,NoSuchFieldException,IllegalArgumentException,IllegalAccessException{
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return(Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
}
