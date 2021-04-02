package com.noodles.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CuratorLockDemo
 * @Description Curator 锁示例
 * @Author noodles
 * @Date 2021/4/2 14:34
 */
public class CuratorLockDemo {
    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")
                .sessionTimeoutMs(4000).retryPolicy(new ExponentialBackoffRetry(4000, 3)).build();
        curatorFramework.start();

        // InterProcessMutex, 可重入锁
        // InterProcessSemaphoreMutex: 分布式排它锁
        // InterProcessReadWriteLock: 分布式读写锁
        // InterProcessMultiLock: 将多个锁作为单个实体管理的容器
        InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, "/locks");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            fixedThreadPool.submit(() -> {
               boolean flag = false;
               try {
                   // 尝试获取锁，最多等待5秒
                   flag = interProcessMutex.acquire(5, TimeUnit.SECONDS);
                   Thread curThread = Thread.currentThread();
                   if (flag) {
                       System.out.println("线程 [" + curThread.getName() +"] 获取锁成功");
                   } else  {
                       System.out.println("线程 [" + curThread.getName() +"] 获取锁失败");
                   }
                   Thread.sleep(2000);
               } catch (Exception e) {
                   e.printStackTrace();
               } finally {
                   if (flag) {
                       try {
                           // 释放锁
                           interProcessMutex.release();
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
               }
            });
        }
    }
}
