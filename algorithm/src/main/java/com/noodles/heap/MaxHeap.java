package com.noodles.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @ClassName MaxHeap
 * @Description 大顶堆
 *      参考链接： https://www.bilibili.com/video/BV1ti4y1879c
 * @Author noodles
 * @Date 2021/3/25 14:34
 */
public class MaxHeap {

    private int capacity;
    private int size = 0;
    private int[] array;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1)/2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int parentIndex) {
        return array[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return array[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return array[getParentIndex(childIndex)];
    }

    // Time Complexity: O(logN)
    public void insert(int item) {
        if (size == capacity) {
            array = Arrays.copyOf(array, capacity * 2);
            capacity = capacity * 2;
        }
        array[size] = item;
        size++;
        heapifyUp();
    }

    // Time Complexity: O(logN)
    public void poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int element = array[0];
        array[0] = array[size - 1];
        size--;
        heapifyDown();
    }

    private int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return array[0];
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < array[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = getRightChildIndex(index);
            }
            if (array[index] < array[largerChildIndex]) {
                swap(index, largerChildIndex);
            } else {
                break;
            }
            index = largerChildIndex;
        }
    }

    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
