package com.noodles.leetcode;

import com.noodles.base.SinglyListNode;

/**
 * @Description: Reverse Linked List
 *      参考链接: 206  https://leetcode.com/problems/reverse-linked-list/
 * @Author: noodles
 * @create: 2021-03-23 21:49
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        SinglyListNode root = new SinglyListNode(1);
        SinglyListNode nodeA = new SinglyListNode(2);
        SinglyListNode nodeB = new SinglyListNode(3);
        SinglyListNode nodeC = new SinglyListNode(4);
        SinglyListNode nodeD = new SinglyListNode(5);
        root.next = nodeA;
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        SinglyListNode newRoot = reverseList(root);
        SinglyListNode temp = newRoot;
        while (temp != null) {
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
    }

    public static SinglyListNode reverseList(SinglyListNode root) {
        return reverseListRec(root, null);
    }

    public static SinglyListNode reverseListRec(SinglyListNode head, SinglyListNode newHead) {
        if (head == null) {
            return newHead;
        }
        SinglyListNode next = head.next;
        head.next = newHead;
        return reverseListRec(next, head);
    }

    public static SinglyListNode reverseList2(SinglyListNode head) {
        SinglyListNode newHead = null;
        while (head != null) {
            SinglyListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

}
