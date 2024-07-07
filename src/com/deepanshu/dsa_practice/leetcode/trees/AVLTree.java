package com.deepanshu.dsa_practice.leetcode.trees;

import com.sun.source.tree.Tree;

public class AVLTree {

    public AVLTree() {}

    private TreeNode root;

    public int height() {
        return height(root);
    }

    private int height(TreeNode treeNode) {
        if (treeNode == null) {
            return -1;
        }
        return treeNode.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode treeNode, int val) {
        if (treeNode == null) {
            treeNode = new TreeNode(val);
            return treeNode;
        }


        if (val < treeNode.val) {
            treeNode.left = insert(treeNode.left, val);
        }

        if (val > treeNode.val) {
            treeNode.right = insert(treeNode.right, val);
        }

        treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;

        return rotate(treeNode);
    }

    private TreeNode rotate(TreeNode treeNode) {
        if (height(treeNode.left) - height(treeNode.right) > 1) {
//            left heavy
            if (height(treeNode.left.left) - height(treeNode.left.right) > 0) {
//                left-left
                return rightRotate(treeNode);
            }

            if (height(treeNode.left.left) - height(treeNode.left.right) < 0) {
//                left-right
                treeNode.left = leftRotate(treeNode.left);
                return rightRotate(treeNode);
            }
        }

        if (height(treeNode.left) - height(treeNode.right) < -1) {
//            right heavy
            if (height(treeNode.right.left) - height(treeNode.right.right) < 0) {
//                right-right
                return leftRotate(treeNode);
            }

            if (height(treeNode.right.left) - height(treeNode.right.right) > 0) {
//                right-left
                treeNode.right = rightRotate(treeNode.right);
                return leftRotate(treeNode);
            }
        }

        return treeNode;
    }

    private TreeNode rightRotate(TreeNode p) {
        TreeNode c = p.left;
        TreeNode t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    private TreeNode leftRotate(TreeNode c) {
        TreeNode p = c.right;
        TreeNode t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    //    Only works on sorted arrays, in general we use self-balancing binary trees
//    TC: N log N
    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);

        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(TreeNode treeNode) {
        if (treeNode ==  null) {
            return true;
        }
        return Math.abs(height(treeNode.left) - height(treeNode.right)) <= 1
                && balanced(treeNode.left)
                && balanced(treeNode.right);
    }


    public void display() {
        display(root, "Root Node: ");
    }

    private void display(TreeNode treeNode, String details) {
        if (treeNode == null) return;

        System.out.println(details + treeNode.val);

        display(treeNode.left, "Left child of " + treeNode.val + " : ");
        display(treeNode.right, "Right child of " + treeNode.val + " : ");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(TreeNode treeNode, int level) {
        if (treeNode == null) return;

        prettyDisplay(treeNode.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + treeNode.val);
        } else {
            System.out.println(treeNode.val);
        }

        prettyDisplay(treeNode.left, level + 1);
    }


    public void preOrder() {
        System.out.println("\nPre Order traversal: ");
        preOrder(root);
    }

    private void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public void inOrder() {
        System.out.println("\nIn Order traversal: ");
        inOrder(root);
    }

    private void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        preOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.right);
    }

    public void postOrder() {
        System.out.println("\nPost Order traversal: ");
        postOrder(root);
    }

    private void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }
}
