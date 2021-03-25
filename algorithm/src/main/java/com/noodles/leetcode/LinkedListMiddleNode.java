package com.noodles.leetcode;

import com.noodles.base.SinglyListNode;

/**
 * @Description: Linked list 找中间节点
 *      参考连接: https://www.bilibili.com/video/BV1QD4y1D7av
 * @Author: noodles
 * @create: 2021-03-25 22:01
 */
public class LinkedListMiddleNode {
    public static void main(String[] args) {

    }

    /**
     * 寻找Linked List 中间节点
     */
    public SinglyListNode linkedListMiddleNode(SinglyListNode head) {
        SinglyListNode i = head;
        SinglyListNode j = head;
        while (j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
        }
        return i;
    }

    /**
     * Linked List 找倒数第 K 个节点
     */
    public SinglyListNode linkedListLastKthNode(SinglyListNode head, int k) {
        SinglyListNode i = head;
        SinglyListNode j = head;
        for (int c = 0; c < k; c++) {
            j = j.next;
        }
        while (j != null) {
            i = i.next;
            j = j.next;
        }
        return i;
    }
}
