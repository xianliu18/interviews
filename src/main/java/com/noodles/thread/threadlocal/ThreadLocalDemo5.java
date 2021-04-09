package com.noodles.thread.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadLocalDemo5
 * @Description TransmittableThreadLocal 与原生 InheritableThreadLocal 性能比较
 *      参考链接： https://mp.weixin.qq.com/s/1VVu25bzea1jzAWz7fKEUA
 * @Author noodles
 * @Date 2021/4/9 17:36
 */
public class ThreadLocalDemo5 {

    private static final AtomicInteger ID_SEQ = new AtomicInteger();
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(1, r -> new Thread(r, "TTL-TEST-" + ID_SEQ.getAndIncrement()));

    private static ThreadLocal<String> THREAD_LOCAL = new InheritableThreadLocal<>();
    // 声明 TransmittableThreadLocal 类型的ThreadLocal
//    private static ThreadLocal<String> THREAD_LOCAL = new TransmittableThreadLocal<>();

    @Test
    public void testThreadLocal() throws InterruptedException {
        try {
            // doSomething()...
            THREAD_LOCAL.set("set-task-init-value");
            Runnable task1 = () -> {
              try {
                  String manTaskCtx = THREAD_LOCAL.get();
                  System.out.println("task1: " + Thread.currentThread() + ", get ctx: " + manTaskCtx);
                  THREAD_LOCAL.set("task1-set-value");
              } finally {
                  THREAD_LOCAL.remove();
              }
            };

            EXECUTOR.submit(task1);

            // doSomething...
            TimeUnit.SECONDS.sleep(3);

            // （2）设置期望 task2 可获取的上下文
            THREAD_LOCAL.set("main-task-value");

            // task2 的异步任务逻辑中期望获取（2）中的上下文
            Runnable task2 = () -> {
                String manTask2 = THREAD_LOCAL.get();
                System.out.println("task2: " + Thread.currentThread() + ", get ctx: " + manTask2);
            };
            // 转换为 TransmittableThreadLocal 增强的 Runnable
//            task2 = TtlRunnable.get(task2);
            EXECUTOR.submit(task2);
        } finally {
            THREAD_LOCAL.remove();
        }
    }
}
