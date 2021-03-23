package com.noodles.tree.binary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName PostOrderDemo
 * @Description 后序遍历 PostOrder   L - R - V
 * @Author noodles
 * @Date 2021/3/23 11:24
 */
public class PostOrderDemo {
    public static void main(String[] args) {
        System.out.println("Two Stacks: ");
        postOrderIterTwoStacks(TreeNode.NodeDemo());
        System.out.println();
        System.out.println("\nOne Stack:");
        postOrderIterOneStack(TreeNode.NodeDemo());
    }

    /**
     * Two Stacks
     */
    public static void postOrderIterTwoStacks(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()) {
            root = s2.pop();
            System.out.print(root.val + "\t");
        }
    }

    /**
     * One Stack
     */
    public static void postOrderIterOneStack(TreeNode root) {
        TreeNode current = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.addFirst(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.poll();
                    System.out.print(temp.val + "\t");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.poll();
                        System.out.print(temp.val + "\t");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
}
