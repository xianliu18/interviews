package com.noodles.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 自定义线程池
 * @Author: noodles
 * @create: 2021-01-20 21:23
 */
public class ThreadPoolTrader implements Executor {

    private final AtomicInteger ctl = new AtomicInteger(0);

    private volatile int corePoolSize;
    private volatile int maximumPoolSize;

    private final BlockingQueue<Runnable> workQueue;


    public ThreadPoolTrader(int corePoolSize, int maximumPoolSize, BlockingQueue<Runnable> workQueue) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
    }

    @Override
    public void execute(Runnable command) {
        int c = ctl.get();
        if (c < corePoolSize) {
            if (!addWorker(command)) {
                reject();
            }
            return;
        }
        if (!workQueue.offer(command)) {
            if (!addWorker(command)) {
                reject();
            }
        }
    }

    private boolean addWorker(Runnable firstTask) {
        if (ctl.get() >= maximumPoolSize) {
            return false;
        }
        Worker worker = new Worker(firstTask);
        worker.thread.start();
        ctl.incrementAndGet();
        return true;
    }

    private final class Worker implements Runnable {

        final Thread thread;
        Runnable firstTask;

        public Worker(Runnable firstTask) {
            this.thread = new Thread(this);
            this.firstTask = firstTask;
        }

        @Override
        public void run() {
            Runnable task = firstTask;
            try {
                while (task != null || (task = getTask()) != null) {
                    task.run();
                    if (ctl.get() > maximumPoolSize) {
                        break;
                    }
                    task = null;
                }
            } finally {
                ctl.decrementAndGet();
            }
        }

        private Runnable getTask() {
            for (;;) {
                try {
                    System.out.println("workQueue.size: " + workQueue.size());
                    return workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void reject() {
        throw new RuntimeException("Error! ctl.count: " + ctl.get() + " workQueue.size: "  + workQueue.size());
    }

    public static void main(String[] args) {
        ThreadPoolTrader threadPoolTrader = new ThreadPoolTrader(2, 2, new ArrayBlockingQueue<>(10));

        for (int i = 0; i < 10; i++) {
            int temp = i;
            threadPoolTrader.execute(() -> {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程名称："+Thread.currentThread().getName()+" -----> 任务编号: " + temp);
            });
        }
    }
}
