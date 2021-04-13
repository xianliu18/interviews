package com.noodles.thread;

/**
 * @ClassName ThreadPoolStateTest
 * @Description ThreadPool 状态测试
 * @Author noodles
 * @Date 2021/4/13 10:22
 */
public class ThreadPoolStateTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;

    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {
        System.out.println("-1的二进制为：" + Integer.toBinaryString(-1));
        System.out.println("RUNNING的二进制为：" + Integer.toBinaryString(-1 << COUNT_BITS));
        System.out.println("SHUTDOWN的二进制为：" + Integer.toBinaryString(0 << COUNT_BITS));
        System.out.println(RUNNING > SHUTDOWN);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);
    }
}
