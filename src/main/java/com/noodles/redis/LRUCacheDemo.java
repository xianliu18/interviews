package com.noodles.redis;

import java.util.Hashtable;

/**
 * @ClassName LRUCacheDemo
 * @Description LRU 算法
 * @Author noodles
 * @Date 2021/1/14 10:18
 */
public class LRUCacheDemo {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    /**
     * @Description Always add the new node right after head.
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * @Description Remove and existing node from the linked list
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public LRUCacheDemo(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // move the accessed node to the head
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value
            node.value = value;
            this.moveToHead(node);
        }
    }
}
