package com.noodles.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 层序遍历
 *      参考连接: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @Author: noodles
 * @create: 2021-04-22 09:10
 */
public class LevelOrderTraversal102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a1 = new TreeNode(9);
        TreeNode a2 = new TreeNode(20);
        TreeNode a3 = new TreeNode(15);
        TreeNode a4 = new TreeNode(7);
        root.left = a1;
        root.right = a2;
        a2.left = a3;
        a2.right = a4;

        List<List<Integer>> result = levelOrder(root);
        System.out.println(JSON.toJSONString(result));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }
        queue.add(root);
        int levelNum = 1;
        int currentCount = 0;
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<>();
            while (levelNum > 0) {
                root = queue.poll();
                subList.add(root.val);
                levelNum--;
                if (root.left != null) {
                    queue.offer(root.left);
                    currentCount++;
                }
                if (root.right != null) {
                    queue.offer(root.right);
                    currentCount++;
                }
            }
            levelNum = currentCount;
            currentCount = 0;
            result.add(subList);
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
