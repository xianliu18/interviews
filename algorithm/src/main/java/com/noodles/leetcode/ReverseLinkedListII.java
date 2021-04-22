package com.noodles.leetcode;

import javax.jnlp.SingleInstanceListener;

import com.noodles.base.SinglyListNode;

/**
 * @Description: 反转链表II
 *      参考连接: https://leetcode.com/problems/reverse-linked-list-ii/
 * @Author: noodles
 * @create: 2021-04-22 10:05
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {

    }

    public static SinglyListNode reverseBetween(SinglyListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        SinglyListNode dummy = new SinglyListNode(0);
        dummy.next = head;
        SinglyListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        SinglyListNode start = pre.next;
        SinglyListNode then = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
