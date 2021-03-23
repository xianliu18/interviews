package com.noodles.tree.binary;

import java.util.Stack;

/**
 * @ClassName PreOrderDemo
 * @Description 前序遍历
 * @Author noodles
 * @Date 2021/3/23 8:50
 */
public class PreOrderDemo {
    /**
     * 前序遍历：V - L - R
     * V: visited 表示当前节点
     * L: left    表示当前节点的左节点
     * R: right   表示当前节点的右节点
     */
    public static void main(String[] args) {

        System.out.println("递归遍历：");
        preOrderRecur(TreeNode.NodeDemo());
        System.out.println();

        System.out.println("\nIter遍历：");
        preOrderIter(TreeNode.NodeDemo());
        System.out.println();

        System.out.println("\nMorris遍历：");
        preOrderMorris(TreeNode.NodeDemo());

    }
    
    /**
     * 递归实现
     */
    public static void preOrderRecur(TreeNode head) {
        if (head != null) {
            System.out.print(head.val + "\t");
            preOrderRecur(head.left);
            preOrderRecur(head.right);
        }
    }

    /**
     * 非递归实现：Stack + iterative
     */
    public static void preOrderIter(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.val + "\t");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    /**
     * Morris 遍历
     *       - 空间复杂度：O(1)
     *       - 时间复杂度: O(n)
     * 参考链接：
     *      - Morris：https://zhuanlan.zhihu.com/p/101321696
     *      - Morris遍历：https://www.cnblogs.com/anniekim/archive/2013/06/15/morristraversal.html
     *
     */
    public static void preOrderMorris(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + "\t");
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    System.out.print(current.val + "\t");
                    current = current.left;
                } else {
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
}
