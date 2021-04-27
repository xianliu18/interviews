package com.noodles.leetcode;

import com.alibaba.fastjson.JSON;
import com.noodles.base.SinglyListNode;

/**
 * @Description: Merge Two Sorted Lists
 *      参考链接: https://leetcode.com/problems/merge-two-sorted-lists/
 * @Author: noodles
 * @create: 2021-04-27 10:11
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        SinglyListNode l1 = new SinglyListNode(1);
        SinglyListNode a = new SinglyListNode(2);
        SinglyListNode b = new SinglyListNode(4);
        SinglyListNode l2 = new SinglyListNode(1);
        SinglyListNode d = new SinglyListNode(3);
        SinglyListNode e = new SinglyListNode(4);

        l1.next = a;
        a.next = b;
        l2.next = d;
        d.next = e;

        SinglyListNode result = mergeTwoSortedList(l1, l2);

        System.out.println(JSON.toJSONString(result));
    }

    public static SinglyListNode mergeTwoSortedList(SinglyListNode l1, SinglyListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        SinglyListNode prev = new SinglyListNode(0);
        SinglyListNode head = prev;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
