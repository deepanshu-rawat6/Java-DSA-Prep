package com.deepanshu.dsa_practice.leetcode.trees;

import com.sun.source.tree.Tree;

import java.util.List;


public class Main_Binary_Tree {

    static TreeNode root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        AVLTree avlTree = new AVLTree();
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

//        int[] nums = {1, 2};
//        int[] nums = {5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 1};
//        int[] nums = {4, 2, Integer.MIN_VALUE, 3, 1};
//        int[] nums = {4, 2, 6, 3, 1, 5, Integer.MIN_VALUE};
//        root = binaryTree.populate(nums);



//        binaryTree.prettyDisplay();
//        treeTraversals.invertTree(root);
//        System.out.println("\nAfter inverting:");
//        binaryTree.prettyDisplay();

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

//        System.out.println(treeTraversals.sumOfLeftLeaves(root));


//        System.out.println(treeTraversals.sumNumbers(root));


//        System.out.println(treeTraversals.hasPathSum(root, 22));

//        root = treeTraversals.addOneRow(root, 1, 3);
//        binaryTree.prettyDisplay();

//        int[] nums = {3,9,20, Integer.MIN_VALUE, Integer.MIN_VALUE,15,7};
//        root = binaryTree.populate(nums);
//        System.out.println(treeTraversals.isBalanced(root));

//        int[] nums = {1, 7, 0, 7, -8, Integer.MIN_VALUE, Integer.MIN_VALUE};
//        int[] nums = {-100, -200, -300, -20, -5, -10, Integer.MIN_VALUE};
//        root = binaryTree.populate(nums);
//        binaryTree.prettyDisplay();
//        System.out.println(binaryTree.height(root));
//        System.out.println(treeTraversals.maxLevelSum(root));

//        int[] nums = {-10, -3, 0, 5, 9};
//        root = treeTraversals.sortedArrayToBST(nums);
//        binaryTree.prettyDisplay(root, 0);




//        AVL Tree
//        for (int i = 0; i < 10; i++) {
//            avlTree.insert(i);
//        }
//        System.out.println(avlTree.height());
//
//        avlTree.prettyDisplay();


        /*

         **************** Create Binary Tree From Descriptions ****************

         */

//        int[][] desc = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
//        root = binaryTree.createBinaryTree(desc);
//
//        binaryTree.prettyDisplay(root, 0);


        /*

         **************** Step-By-Step Directions From a Binary Tree Node to Another ****************

         */

//        int nums[] = {5, 1, 2, 3, Integer.MIN_VALUE, 6, 4};
//        int startVal = 3, destVal =6;
//        root = binaryTree.populate(nums);
//
//        System.out.println(binaryTree.getDirections(root, startVal, destVal));

        /*

         **************** Step-By-Step Directions From a Binary Tree Node to Another ****************

         */

//        int nums[] = {1,2,3,4,5,6,7};
//        root = binaryTree.populate(nums);
//
//        binaryTree.prettyDisplay(root, 0);
//
//        int[] to_delete = {3, 5};
//
//        List<TreeNode> forest = treeTraversals.delNodes(root, to_delete);
//
//        for (TreeNode node : forest) {
//            System.out.println(node.val);
//        }
    }
}
