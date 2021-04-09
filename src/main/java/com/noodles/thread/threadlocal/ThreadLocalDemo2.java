package com.noodles.thread.threadlocal;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @ClassName ThreadLocalTest
 * @Description ThreadLocal 测试类
 *      参考链接： https://www.cnblogs.com/wang-meng/p/12856648.html
 * @Author noodles
 * @Date 2021/1/18 11:54
 */
public class ThreadLocalDemo2 {
    private List<String> messages = Lists.newArrayList();

    private static final ThreadLocal<ThreadLocalDemo2> holder = ThreadLocal.withInitial(ThreadLocalDemo2::new);

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
        ThreadLocalDemo2.add("This is a test");

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 存储变量为：" + holder.get().messages);
        }).start();

        System.out.println("main类线程变量： " + holder.get().messages);
        ThreadLocalDemo2.clear();
    }

}
