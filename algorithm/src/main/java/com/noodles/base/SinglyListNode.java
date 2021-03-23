package com.noodles.base;

/**
 * @Description: singly-linked list
 * @Author: noodles
 * @create: 2021-03-23 21:50
 */
public class SinglyListNode {
    public int val;
    public SinglyListNode next;

    public SinglyListNode() {
    }

    public SinglyListNode(int val) {
        this.val = val;
    }

    public SinglyListNode(int val, SinglyListNode next) {
        this.val = val;
        this.next = next;
    }
}
