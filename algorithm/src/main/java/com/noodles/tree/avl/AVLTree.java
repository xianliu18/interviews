package com.noodles.tree.avl;

/**
 * @Description: AVL 树   平衡二叉搜索树
 *              Self-balancing Binary Search Tree
 *
 *              参考链接：https://www.cnblogs.com/skywang12345/p/3577479.html
 * @Author: noodles
 * @create: 2021-03-23 21:27
 */
public class AVLTree<T extends Comparable<T>> {

    private AVLTreeNode<T> mRoot;

    // AVL 树的节点
    class AVLTreeNode<T extends Comparable<T>> {
        T key;    // 关键字(键值)
        int height;
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

}
