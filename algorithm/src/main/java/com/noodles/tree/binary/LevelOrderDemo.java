package com.noodles.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LevelOrderDemo
 * @Description 层级遍历
 * @Author noodles
 * @Date 2021/3/23 16:37
 */
public class LevelOrderDemo {

    public static void main(String[] args) {
        System.out.println("LevelOrder 遍历: ");
        levelOrderTraversal(TreeNode.NodeDemo());
        System.out.println();

        System.out.println("\nLevelByLevel 遍历：");
        levelByLevelTraversal(TreeNode.NodeDemo());
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.val + "\t");
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }

    public static void levelByLevelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                root = q1.poll();
                System.out.print(root.val + "\t");
                if (root.left != null) {
                    q2.add(root.left);
                }
                if (root.right != null) {
                    q2.add(root.right);
                }
            }
            // 打印换行符
            System.out.println();
            while (!q2.isEmpty()) {
                root = q2.poll();
                System.out.print(root.val + "\t");
                if (root.left != null) {
                    q1.add(root.left);
                }
                if (root.right != null) {
                    q1.add(root.right);
                }
            }
            System.out.println();
        }
    }
}
