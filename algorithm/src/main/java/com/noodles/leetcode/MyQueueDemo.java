package com.noodles.leetcode;

import com.noodles.base.MyQueue;

/**
 * @ClassName MyQueueDemo
 * @Description MyQueue 队列测试类
 * @Author noodles
 * @Date 2021/3/24 8:53
 */
public class MyQueueDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.pop());
    }
}
