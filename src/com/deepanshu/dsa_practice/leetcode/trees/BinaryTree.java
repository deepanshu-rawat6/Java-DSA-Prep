package com.deepanshu.dsa_practice.leetcode.trees;


import java.util.*;

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

    public void prettyDisplay(TreeNode treeNode, int level) {
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

//    https://leetcode.com/problems/create-binary-tree-from-descriptions/description/
//    Create Binary Tree From Descriptions
    public TreeNode createBinaryTree(int[][] desc) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] des : desc) {
            int parent = des[0], child = des[1], isLeft = des[2];
            children.add(child);

            TreeNode node = map.getOrDefault(parent, new TreeNode(parent));
            if (isLeft == 1) {
                node.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.left);
            } else {
                node.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.right);
            }

            map.put(parent, node);
        }

        int root = -1;
        for (int[] des : desc) {
            if (!children.contains(des[0])) {
                root = des[0];
                break;
            }
        }

        return map.getOrDefault(root, null);
    }


//    StringBuilder sb;
//    public String getDirections(TreeNode root, int startValue, int destValue) {
//        sb = new StringBuilder();
//
//        if (root == null) return "";
//
//        root = helper(root, startValue, destValue, sb);
//
//        return sb.toString();
//    }
//
//    private TreeNode helper(TreeNode root, int startValue, int destValue, StringBuilder sb) {
//        if (root == null) return null;
//
//        if (root.val == startValue || root.val == destValue) {
//            sb.append('U');
//            return root;
//        }
//
//        TreeNode left = helper(root.left, startValue, destValue, sb.append('L'));
//        TreeNode right = helper(root.right, startValue, destValue, sb.append('R'));
//
//        if (left != null && right != null) {
//            return root;
//        }
//
//        return left != null ? left : right;
//    }


    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) return "";

        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        TreeNode lca = findLCA(root, startValue, destValue);

        System.out.println(lca.val);

        findStartPath(lca, startValue, startPath);
        findDestPath(lca, destValue, destPath);

        return startPath.toString() + destPath.reverse().toString();
    }

    private boolean findStartPath(TreeNode root, int startValue, StringBuilder startPath) {
        if (root == null) return false;

        if (root.val == startValue) {
            return true;
        }

        if (findStartPath(root.left, startValue, startPath) || findStartPath(root.right, startValue, startPath)) {
            startPath.append('U');
            return true;
        }

        return false;
    }

    private boolean findDestPath(TreeNode root, int destValue, StringBuilder destPath) {
        if (root == null) return false;

        if (root.val == destValue) {
            return true;
        }

        if (findDestPath(root.right, destValue, destPath)) {
            destPath.append('R');
            return true;
        }

        if (findDestPath(root.left, destValue, destPath)) {
            destPath.append('L');
            return true;
        }

        return false;
    }

    private TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null) return null;

        if (root.val == startValue || root.val == destValue) return root;

        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);

        if (left != null && right != null) return root;

        return left == null ? right : left;
    }
}
