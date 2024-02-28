package com.deepanshu.dsa_practice.leetcode.trees;

public class BinarySearchTree {

    private TreeNode root;
    public BinarySearchTree() {}

    public int height(TreeNode treeNode) {
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

        return treeNode;
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

}


