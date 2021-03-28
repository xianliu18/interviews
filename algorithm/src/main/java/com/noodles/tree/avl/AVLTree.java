package com.noodles.tree.avl;

/**
 * @Description: AVL 树   平衡二叉搜索树
 *              Self-balancing Binary Search Tree
 *
 *              参考链接：https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 *                      https://www.cnblogs.com/skywang12345/p/3577479.html
 *
 * @Author: noodles
 * @create: 2021-03-23 21:27
 */
public class AVLTree<T extends Comparable<T>> {

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        tree.mRoot = tree.insert(tree.mRoot, 10);
        tree.mRoot = tree.insert(tree.mRoot, 20);
        tree.mRoot = tree.insert(tree.mRoot, 30);
        tree.mRoot = tree.insert(tree.mRoot, 40);
        tree.mRoot = tree.insert(tree.mRoot, 50);
        tree.mRoot = tree.insert(tree.mRoot, 25);

        System.out.println();
        tree.preOrder(tree.mRoot);
    }

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

        public AVLTreeNode(T key) {
            this.key = key;
            this.height = 1;
        }
    }

    private int height(AVLTreeNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }
        return 0;
    }

    public int height() {
        return height(mRoot);
    }

    private AVLTreeNode rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode z = x.right;

        // Perform Rotation
        x.right = y;
        y.left = z;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLTreeNode leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode z = y.left;

        // Perform rotation
        y.left = x;
        x.right = z;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    int getBalance(AVLTreeNode n) {
        if (n == null) {
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    public AVLTreeNode insert(AVLTreeNode node, T key) {
        // 1, Perform the normal BST insertion
        if (node == null) {
            return new AVLTreeNode(key);
        }

        if (key.compareTo((T) node.key) < 0) {
            node.left = insert(node.left, key);
        } else if (key.compareTo((T)node.key) > 0){
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys not allowed
            return node;
        }

        // 2, Update height of this ancesstor node
        node.height = 1 + max(height(node.left), height(node.right));

        // 3, Get the balance factor of this ancestor
        int balance = getBalance(node);

        if (balance > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if (balance < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }

        return node;
    }


    void preOrder(AVLTreeNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
