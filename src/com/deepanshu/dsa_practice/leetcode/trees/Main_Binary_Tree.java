package com.deepanshu.dsa_practice.leetcode.trees;

import com.sun.source.tree.Tree;

import java.util.List;


public class Main_Binary_Tree {

    static TreeNode root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeTraversals treeTraversals = new TreeTraversals();


//        Scanner sc = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
////        tree.display();
//        tree.prettyDisplay();
//        tree.preOrder();
//        tree.inOrder();
//        tree.postOrder();


//        BST tree = new BST();
//        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
//        tree.populate(nums);
//        tree.display();

        int[] nums = {1,2,3,4,5,6,7,8,9, Integer.MIN_VALUE,Integer.MIN_VALUE,10, Integer.MIN_VALUE, Integer.MIN_VALUE, 11};
        root = binaryTree.populate(nums);

        binaryTree.prettyDisplay();
//        treeTraversals.invertTree(root);
        System.out.println("\nAfter inverting:");
        binaryTree.prettyDisplay();

//        List<List<Integer>> levelOrderTraversal = treeTraversals.levelOrder(root);
//        System.out.println(levelOrderTraversal);
//
//        List<List<Integer>> levelOrderTraversalBottom = treeTraversals.levelOrderBottom(root);
//        System.out.println(levelOrderTraversalBottom);

//        List<Double> avgLevelOrder = treeTraversals.averageOfLevels(root);
//        System.out.println(avgLevelOrder);
//
//        TreeNode node = treeTraversals.levelOrderSuccessor(root, 10);
//        System.out.println("Value: " + node.val);
//
//        List<Integer> preOrderTraversal = treeTraversals.preorderTraversal(root);
//        System.out.println(preOrderTraversal);
//
//        List<Integer> inOrderTraversal = treeTraversals.inorderTraversal(root);
//        System.out.println(inOrderTraversal);
//
//        List<Integer> postOrderTraversal = treeTraversals.postorderTraversal(root);
//        System.out.println(postOrderTraversal);

//        TreeNode root1 = binaryTree.populate(new int[]{1, 2, 1});
//        TreeNode root2 = binaryTree.populate(new int[]{1, 1, 2});

//        TreeNode root1 = binaryTree.populate(new int[]{1, 2, 3});
//        TreeNode root2 = binaryTree.populate(new int[]{1, 2, 3});
//
//        System.out.println(treeTraversals.isSameTree(root1, root2));

//        List<List<Integer>> zigzagOrderTraversal = treeTraversals.zigzagLevelOrder(root);
//        System.out.println(zigzagOrderTraversal);
    }
}
