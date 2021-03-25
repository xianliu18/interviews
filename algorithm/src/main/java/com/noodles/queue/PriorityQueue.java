package com.noodles.queue;

/**
 * @ClassName PriorityQueue
 * @Description 优先队列
 *      参考链接： https://www.bilibili.com/video/BV1ti4y1879c
 * @Author noodles
 * @Date 2021/3/25 13:59
 */
public class PriorityQueue {
    static class Node {
        int value;
        int priority;
        Node next;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    Node head = null;

    public void push(int value, int priority) {
        if (head == null) {
            head = new Node(value, priority);
            return;
        }
        Node cur = head;
        Node newNode = new Node(value, priority);
        if (head.priority < priority) {
            newNode.next = head;
            this.head = newNode;
        } else {
            while (cur.next != null && cur.next.priority > priority) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    public Node peek() {
        return head;
    }

    public Node pop() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
