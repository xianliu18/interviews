package com.noodles.thread;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @ClassName ThreadLocalTest
 * @Description ThreadLocal 测试类
 * @Author noodles
 * @Date 2021/1/18 11:54
 */
public class ThreadLocalTest {
    private List<String> messages = Lists.newArrayList();

    private static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();
        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("This is a test");

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + holder.get().messages);
        }).start();

        System.out.println("main类线程变量： " + holder.get().messages);
        ThreadLocalTest.clear();
    }

}
