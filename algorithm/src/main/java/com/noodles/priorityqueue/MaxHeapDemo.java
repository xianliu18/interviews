package com.noodles.priorityqueue;


/**
 * @Description: MaxHeap 测试类
 * @Author: noodles
 * @create: 2021-03-28 13:26
 */
public class MaxHeapDemo {
    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>(9);
        heap.insert(10);
        heap.insert(40);
        heap.insert(30);
        heap.insert(60);
        heap.insert(90);
        heap.insert(70);
        heap.insert(20);
        heap.insert(50);
        heap.insert(80);
        // 删除最大元素
        System.out.println(heap.delMax());
    }
}
