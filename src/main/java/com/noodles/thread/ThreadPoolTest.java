package com.noodles.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 线程池测试类
 * @Author: noodles
 * @create: 2021-01-20 21:15
 */
@Slf4j
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(10));
        threadPoolExecutor.execute(()->{
            System.out.println("hi 线程池!");
        });
        threadPoolExecutor.shutdown();
    }

}
