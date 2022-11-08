package com.noodles.thread.lock.reentrant.spinlock;

import com.google.common.cache.CacheLoader;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @ClassName CLHLock
 * @Description CLH 锁实现
 *      参考链接:  https://bugstack.cn/interview/2020/11/04/面经手册-第16篇-码农会锁-ReentrantLock之公平锁讲解和实现.html
 *               https://www.cnblogs.com/scholar-hwg/p/12172154.html
 * @Author noodles
 * @Date 2021/1/19 17:57
 */
@Slf4j
public class CLHLock implements Lock {

    private final ThreadLocal<CLHLock.Node> prev;
    private final ThreadLocal<CLHLock.Node> node;
    private final AtomicReference<CLHLock.Node> tail = new AtomicReference<>(new CLHLock.Node());

    private static class Node {
        private volatile boolean locked;
    }

    public CLHLock() {
        this.prev = ThreadLocal.withInitial(() -> null);
        this.node = ThreadLocal.withInitial(CLHLock.Node::new);
    }

    @Override
    public void lock() {
        log.info("当前线程：" + Thread.currentThread().getName());
        final Node node = this.node.get();
        node.locked = true;
        Node pred_node = this.tail.getAndSet(node);
        this.prev.set(pred_node);
        // 自旋
        while (pred_node.locked);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        final Node node = this.node.get();
        node.locked = false;
        this.node.set(this.prev.get());
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
