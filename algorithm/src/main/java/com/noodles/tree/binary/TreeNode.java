package com.noodles.tree.binary;

/**
 * @ClassName TreeNode
 * @Description 二叉树定义
 * @Author noodles
 * @Date 2021/3/23 8:47
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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

    public static TreeNode NodeDemo() {
        TreeNode root = new TreeNode(10);
        TreeNode t1 = new TreeNode(15);
        TreeNode t2 = new TreeNode(30);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(9);
        TreeNode t8 = new TreeNode(8);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.right = t5;
        t3.left = t6;
        t5.left = t7;
        t5.right = t8;
        return root;
    }
}
