package com.noodles.concurrent;

import com.noodles.concurrent.bean.Stock;
import com.noodles.concurrent.mysql.DbLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 库存测试
 * @Author: noodles
 * @create: 2021-05-13 16:39
 */
public class StockMain {

    private static Lock lock = new ReentrantLock();

    @Autowired
    private static DbLock dbLock;

    static {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dbLock = context.getBean(DbLock.class);
    }

    static class StockThread implements Runnable {
        @Override
        public void run() {

            // 上锁
//            lock.lock();
            dbLock.lock();

            // 调用减少库存方法
            boolean b = new Stock().reduceStock();

            // 解锁
//            lock.unlock();
            dbLock.unlock();

            if (b) {
                System.out.println(Thread.currentThread().getName() + " 减少库存成功");
            } else {
                System.out.println(Thread.currentThread().getName() + " 减少库存失败");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new StockThread(), "线程1").start();
        new Thread(new StockThread(), "线程2").start();
    }
}
