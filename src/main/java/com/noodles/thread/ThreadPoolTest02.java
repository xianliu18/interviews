package com.noodles.thread;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolTest02
 * @Description ThreadPool示例
 *      参考链接： https://www.cnblogs.com/wang-meng/p/12945703.html
 * @Author noodles
 * @Date 2021/2/9 17:40
 */
public class ThreadPoolTest02 {

    static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolTest02.class);

    private static final int DEFAULT_MAX_CONCURRENT = Runtime.getRuntime().availableProcessors() * 2;

    private static final String THREAD_POOL_NAME = "MyThreadPool-%d";

    private static final ThreadFactory FACTORY = new DefaultThreadFactory(THREAD_POOL_NAME, true);

    private static final int DEFAULT_SIZE = 500;

    private static final long DEFAULT_KEEP_ALIVE = 60L;

    private static ExecutorService executor;

    private static BlockingQueue<Runnable> executeQueue = new ArrayBlockingQueue<>(DEFAULT_SIZE);

    static {
        try {
            executor = new ThreadPoolExecutor(DEFAULT_MAX_CONCURRENT, DEFAULT_MAX_CONCURRENT + 2, DEFAULT_KEEP_ALIVE, TimeUnit.SECONDS,
                            executeQueue, FACTORY);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                LOGGER.info("MyThreadPool shutting down.");
                executor.shutdown();

                try {
                    if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                        LOGGER.error("MyThreadPool shutdown immediately due to wait timeout.");
                        executor.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    LOGGER.error("MyThreadPool shutdown interrupted.");
                    executor.shutdownNow();
                }
            }));
        } catch (Exception e) {
            LOGGER.error("MyThreadPool init error.", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    private ThreadPoolTest02() {

    }

    public static boolean execute(Runnable task) {
        try {
            executor.execute(task);
        } catch (RejectedExecutionException e) {
            LOGGER.error("Task executing was rejected.", e);
            return false;
        }

        return true;
    }

    public static <T> Future<T> submitTask(Callable<T> task) {
        try {
            return executor.submit(task);
        } catch (RejectedExecutionException e) {
            LOGGER.error("Task executing was rejected.", e);
            throw new UnsupportedOperationException("Unable to submit the task, rejected.", e);
        }
    }

}
