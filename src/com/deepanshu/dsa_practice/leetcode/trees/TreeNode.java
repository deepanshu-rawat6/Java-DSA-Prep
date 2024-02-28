package com.deepanshu.dsa_practice.leetcode.trees;

import com.sun.source.tree.Tree;

public class TreeNode {

    int val;

    TreeNode left;
    TreeNode right;

    int height;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }
}
