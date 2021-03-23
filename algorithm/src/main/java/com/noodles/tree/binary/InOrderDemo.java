package com.noodles.tree.binary;

import java.util.Stack;

/**
 * @ClassName InOrderDemo
 * @Description 中序遍历 L - V - R
 * @Author noodles
 * @Date 2021/3/23 9:43
 */
public class InOrderDemo {
    public static void main(String[] args) {
        System.out.println("递归遍历: ");
        inOrderRecur(TreeNode.NodeDemo());
        System.out.println();

        System.out.println("\nIter遍历：");
        inOrderIter(TreeNode.NodeDemo());
        System.out.println();

        System.out.println("\nMorris遍历：");
        inOrderMorris(TreeNode.NodeDemo());
        System.out.println();
    }
    
    /**
     * 递归遍历
     */
    public static void inOrderRecur(TreeNode head) {
        if (head != null) {
            inOrderRecur(head.left);
            System.out.print(head.val + "\t");
            inOrderRecur(head.right);
        }
    }

    /**
     * Iter遍历
     */
    public static void inOrderIter(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                head = stack.pop();
                System.out.print(head.val + "\t");
                head = head.right;
            }
        }
    }

    /**
     * Morris 遍历：
     *     - 空间复杂度：O(1)
     *     - 时间复杂度: O(n)
     *     - 参考链接： https://www.cnblogs.com/anniekim/archive/2013/06/15/morristraversal.html
     */
    public static void inOrderMorris(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            // left is null then print the node and go to right
            if (current.left == null) {
                System.out.print(current.val + "\t");
                current = current.right;
            } else {
                TreeNode predecessor = current.left;

                // To keep going right till right node is null
                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // if right node is null then go left after establishing link from predecessor to current
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // left is already visit. Go right after visiting current.
                    predecessor.right = null;
                    System.out.print(current.val + "\t");
                    current = current.right;
                }
            }
        }
    }
}
