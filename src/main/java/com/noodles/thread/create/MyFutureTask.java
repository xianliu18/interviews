package com.noodles.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description: 实现Callable接口
 * @Author: noodles
 * @create: 2021-01-31 22:07
 */
public class MyFutureTask {
    public static void main(String[] args) {
        // 构建 Callable
        MyCallable myCallable = new MyCallable();

        // 通过myCallable,构建FutureTask
        FutureTask futureTask = new FutureTask(myCallable);

        // 通过futureTask构造Thread, 并且执行start方法
        new Thread(futureTask).start();
    }

}

class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is running...");
        return null;
    }
}
