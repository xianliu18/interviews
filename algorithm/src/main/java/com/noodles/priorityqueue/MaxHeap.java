package com.noodles.priorityqueue;

/**
 * @Description: 二叉堆
 *      参考连接: < 算法(第4版)>
 * @Author: noodles
 * @create: 2021-03-28 13:15
 */
public class MaxHeap<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxHeap(int maxN) {
        pq = (Key[])new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        swap(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            swap(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2 * k <= N) {
            int j = 2 * k;
            while (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
