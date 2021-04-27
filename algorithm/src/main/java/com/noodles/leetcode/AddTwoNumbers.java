package com.noodles.leetcode;

import com.alibaba.fastjson.JSON;
import com.noodles.base.SinglyListNode;

/**
 * @Description: Add Two Numbers
 *      参考连接: https://leetcode.com/problems/add-two-numbers/
 * @Author: noodles
 * @create: 2021-04-27 09:52
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        SinglyListNode l1 = new SinglyListNode(2);
        l1.next = new SinglyListNode(4);
        l1.next.next = new SinglyListNode(3);

        SinglyListNode l2 = new SinglyListNode(5);
        l2.next = new SinglyListNode(6);
        l2.next.next = new SinglyListNode(4);

        SinglyListNode result = addTwoNumbers(l1, l2);
        System.out.println(JSON.toJSONString(result));
    }

    private static SinglyListNode addTwoNumbers(SinglyListNode l1, SinglyListNode l2) {
        SinglyListNode prev = new SinglyListNode(0);
        SinglyListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            SinglyListNode cur = new SinglyListNode(0);
            int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}
