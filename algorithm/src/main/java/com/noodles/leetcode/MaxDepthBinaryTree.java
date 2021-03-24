package com.noodles.leetcode;

import com.noodles.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MaxDepthBinaryTree
 * @Description  Maximum Depth of Binary Tree
 *      参考链接：
 *          - https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @Author noodles
 * @Date 2021/3/24 11:40
 */
public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode nodeA = new TreeNode(9);
        TreeNode nodeB = new TreeNode(20);
        TreeNode nodeC = new TreeNode(15);
        TreeNode nodeD = new TreeNode(7);
        TreeNode nodeF = new TreeNode(18);
        TreeNode nodeG = new TreeNode(21);
        root.left = nodeA;
        root.right = nodeB;
        nodeA.right = nodeF;
        nodeF.left = nodeG;
        nodeB.left = nodeC;
        nodeB.right = nodeD;

//        System.out.println("Recur: " + maxDepthRecur(root));

        System.out.println("BFS: " + maxDepthBFS(root));
    }


    public static int maxDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = root.left == null ? 0 : maxDepthRecur(root.left);
        int rightMax = root.right == null ? 0 : maxDepthRecur(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }

    public static int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}
