package com.noodles.base;

/**
 * @ClassName TreeNode
 * @Description 二叉树
 * @Author noodles
 * @Date 2021/3/24 11:38
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
