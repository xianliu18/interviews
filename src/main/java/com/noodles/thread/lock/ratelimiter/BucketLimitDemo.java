package com.noodles.thread.lock.ratelimiter;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName BucketLimitDemo
 * @Description 漏桶算法限流
 *      参考链接： https://mp.weixin.qq.com/s/37WkBzmGb4Fevbk4HQEISw
 * @Author noodles
 * @Date 2021/4/2 17:58
 */
public class BucketLimitDemo {
    public static class BucketLimit {
        static AtomicInteger threadNum = new AtomicInteger(1);
        // 容量
        private int capacity;
        // 流速
        private int flowRate;
        // 流速时间单位
        private TimeUnit flowRateUnit;
        private BlockingQueue<Node> queue;
        // 漏桶流出的任务时间间隔（纳秒）
        private long flowRateNanosTime;

        public BucketLimit(int capacity, int flowRate, TimeUnit flowRateUnit) {
            this.capacity = capacity;
            this.flowRate = flowRate;
            this.flowRateUnit = flowRateUnit;
            this.bucketThreadWork();
        }

        // 漏桶线程
        public void bucketThreadWork() {
            this.queue = new ArrayBlockingQueue<>(capacity);
            // 漏桶流出的任务时间间隔（纳秒）
            this.flowRateNanosTime = flowRateUnit.toNanos(1) / flowRate;
            Thread thread = new Thread(this::bucketWork);
            thread.setName("漏桶线程： " + threadNum.getAndIncrement());
            thread.start();
        }

        // 漏桶线程开始工作
        public void bucketWork() {
            while (true) {
                Node node = this.queue.poll();
                if (Objects.nonNull(node)) {
                    // 唤醒任务线程
                    LockSupport.unpark(node.thread);
                }
                // 休眠 flowRateNanosTime
                LockSupport.parkNanos(this.flowRateNanosTime);
            }
        }

        // 返回一个漏桶
        public static BucketLimit build(int capacity, int flowRate, TimeUnit flowRateUnit) {
            if (capacity < 0 || flowRate < 0) {
                throw new IllegalArgumentException("capacity, flowRate 必须大于0！");
            }
            return new BucketLimit(capacity, flowRate, flowRateUnit);
        }

        // 当前线程加入漏桶， 返回false， 表示漏桶已满；true， 表示被漏桶限流成功，可以继续处理任务
        public boolean acquire() {
            Thread thread = Thread.currentThread();
            Node node = new Node(thread);
            if (this.queue.offer(node)) {
                LockSupport.park();
                return true;
            }
            return false;
        }

        // 漏桶中存放的元素
        class Node {
            private Thread thread;

            public Node(Thread thread) {
                this.thread = thread;
            }
        }
    }

    public static void main(String[] args) {
        BucketLimit bucketLimit = BucketLimit.build(10, 60, TimeUnit.MINUTES);
        for (int i = 0; i < 15; i++) {
            new Thread(() -> {
                boolean acquire = bucketLimit.acquire();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + "--->"+ acquire);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
