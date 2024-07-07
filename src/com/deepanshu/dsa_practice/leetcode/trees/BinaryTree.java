package com.deepanshu.dsa_practice.leetcode.trees;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {}

    private TreeNode root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root Node: ");

        int value = scanner.nextInt();

        root = new TreeNode(value);

        populate(scanner, root);
    }

    private void populate(Scanner scanner, TreeNode treeNode) {
        System.out.println("Do you want to enter left of " + treeNode.val);
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.println("Enter the value of the left of " + treeNode.val);
            int value = scanner.nextInt();
            treeNode.left = new TreeNode(value);
            populate(scanner, treeNode.left);
        }


        System.out.println("Do you want to enter right of " + treeNode.val);
        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.println("Enter the value of the right of " + treeNode.val);
            int value = scanner.nextInt();
            treeNode.right = new TreeNode(value);
            populate(scanner, treeNode.right);
        }
    }

    public TreeNode populate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        root = new TreeNode(nums[0]);

        root = populateTree(nums);

        return root;
    }

    private TreeNode populateTree(int[] nums) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < nums.length) {
            TreeNode currentNode = queue.poll();
            if (i < nums.length) {
                if (nums[i] == Integer.MIN_VALUE) {
                    currentNode.left = null;
                } else {
                    currentNode.left = new TreeNode(nums[i]);
                    queue.offer(currentNode.left);
                }
                i++;
            }
            if (i < nums.length) {
                if (nums[i] == Integer.MIN_VALUE) {
                    currentNode.right = null;
                } else {
                    currentNode.right = new TreeNode(nums[i]);
                    queue.offer(currentNode.right);
                }
                i++;
            }
        }
        return root;
    }

    public void display() {
        display(root, " ");
    }

    private void display(TreeNode treeNode, String indent) {
        if (treeNode == null) {
            return;
        }

        System.out.println(indent + treeNode.val);
        display(treeNode.left, indent + "\t");
        display(treeNode.right , indent +"\t");
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

    public int height(TreeNode root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
