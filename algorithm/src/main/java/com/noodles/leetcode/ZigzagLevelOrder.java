package com.noodles.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: ZigzagTraversal
 *      参考连接: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * @Author: noodles
 * @create: 2021-04-27 09:36
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);
        root.right = b;
        b.left = c;
        b.right = d;

        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(JSON.toJSONString(result));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (order) {
                    temp.add(n.val);
                } else {
                    temp.add(0, n.val);
                }
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            result.add(temp);
            size = q.size();
            order = order ? false : true;
        }
        return result;
    }
}
