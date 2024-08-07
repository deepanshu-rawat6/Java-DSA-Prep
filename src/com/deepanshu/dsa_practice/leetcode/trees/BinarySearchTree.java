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


