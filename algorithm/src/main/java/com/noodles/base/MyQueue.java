package com.noodles.base;

import java.util.Stack;

/**
 * @ClassName MyQueue
 * @Description 用栈实现队列
 *     参考链接: 232  https://leetcode.com/problems/implement-queue-using-stacks/
 * @Author noodles
 * @Date 2021/3/24 8:50
 */
public class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {}

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

}
