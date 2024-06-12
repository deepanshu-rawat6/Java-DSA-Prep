package com.deepanshu.dsa_practice.leetcode.trees;

import java.util.*;

public class TreeTraversals {

//    https://leetcode.com/problems/binary-tree-preorder-traversal/description/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = traversalPreOder(root, list);
        return list;
    }

    public List<Integer> traversalPreOder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return list;
        }
        list.add(treeNode.val);
        traversalPreOder(treeNode.left, list);
        traversalPreOder(treeNode.right, list);
        return list;
    }

//    https://leetcode.com/problems/binary-tree-inorder-traversal/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = traversalInOder(root, list);
        return list;
    }

    public List<Integer> traversalInOder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return list;
        }
        traversalInOder(treeNode.left, list);
        list.add(treeNode.val);
        traversalInOder(treeNode.right, list);
        return list;
    }

//    https://leetcode.com/problems/binary-tree-postorder-traversal/description/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = traversalPostOder(root, list);
        return list;
    }

    public List<Integer> traversalPostOder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return list;
        }
        traversalPostOder(treeNode.left, list);
        traversalPostOder(treeNode.right, list);
        list.add(treeNode.val);
        return list;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*

     **************** BFS (Breadth First Search) ****************

     */


//    https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                assert queue.peek() != null;
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                assert queue.peek() != null;
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                currentLevel.add(Objects.requireNonNull(queue.poll()).val);
            }

            res.add(currentLevel);
        }

        return res;
    }

//    https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    if (root == null) {
        return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int levelSize = queue.size();

        List<Integer> currentLevel = new ArrayList<>();

        for (int i = 0; i < levelSize; i++) {
            if (queue.peek().left != null) {
                queue.offer(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.offer(queue.peek().right);
            }
            currentLevel.add(queue.poll().val);
        }

        res.add(0, currentLevel);
    }

//    Collections.reverse(res);

    return res;
}


//    https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new ArrayList<>();

        if (root == null) {
            return resList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double avgLevel = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                avgLevel += currentNode.val;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            avgLevel = avgLevel / levelSize;

            resList.add(avgLevel);

        }
        return resList;
    }


//    Level Order Successor of a node
    public TreeNode levelOrderSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }

        return queue.peek();
    }


//    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean isRev = false;
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if (!isRev) {
                    TreeNode currNode = deque.pollFirst();
                    if (currNode.left != null) {
                        deque.offerLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        deque.offerLast(currNode.right);
                    }
                    currLevel.add(currNode.val);
                } else {
                    TreeNode currNode = deque.pollLast();
                    if (currNode.right != null) {
                        deque.offerFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        deque.offerFirst(currNode.left);
                    }
                    currLevel.add(currNode.val);
                }
            }
            isRev = !isRev;
            resList.add(currLevel);
        }

        return resList;
    }


//    https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftmost = root;

        while (leftmost.left != null) {
            Node curr = leftmost;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

//    https://leetcode.com/problems/invert-binary-tree/

//    DFS
    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = invertTreeDFS(root.right);
        node.right = invertTreeDFS(root.left);
        return node;
    }

//    BFS
//    public TreeNode invertTreeBFS(TreeNode root) {
//
//    }

//    BFS
//    public boolean isEvenOddTree(TreeNode root) {
//
//    }

//    BFS
//    public TreeNode invertTreeBFS(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode treeNode = queue.
//            }
//        }
//    }

//    https://leetcode.com/problems/sum-of-left-leaves/?envType=daily-question&envId=2024-04-14

    public int sumOfLeftLeaves(TreeNode root) {
//        Using BFS

//        if (root == null) {
//            return 0;
//        }
//
//        int res = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode curr = queue.poll();
//
//            if (curr.left != null && curr.left.left == null && curr.left.right == null) {
//                res += curr.left.val;
//            }
//            if (curr.left != null) queue.offer(curr.left);
//            if (curr.right != null) queue.offer(curr.right);
//        }
//
//        return res;

//        Using DFS

        if (root == null) {
            return 0;
        }

        int res = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }

        res += sumOfLeftLeaves(root.right);

        return res;
    }

//    https://leetcode.com/problems/diameter-of-binary-tree/description/

    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        height(root);
        return maxDepth;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int L = height(root.left);
        int R = height(root.right);

        maxDepth = Math.max(maxDepth, L + R + 2);

        return 1 + Math.max(L, R);
    }


//    https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=daily-question&envId=2024-04-15

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode root, int n) {
        if (root == null) {
            return 0;
        }

        if (root.right == null && root.left == null) {
            return n * 10 + root.val;
        }

        return sum(root.left, n * 10 + root.val) + sum(root.right, n * 10 + root.val);
    }

//    https://leetcode.com/problems/path-sum/

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum - root.val == 0) return true;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

//    https://leetcode.com/problems/add-one-row-to-tree/description/?envType=daily-question&envId=2024-04-16

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

//        BFS


        if (depth == 1) {
            return new TreeNode(val, root, null);
        } else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int k = 1;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    if (k == depth - 1) {
                        assert queue.peek() != null;
                        TreeNode treeNode1 = new TreeNode(val, queue.peek().left, null);
                        TreeNode treeNode2 = new TreeNode(val, null, queue.peek().right);
                        queue.peek().left = treeNode1;
                        queue.peek().right = treeNode2;
                        queue.poll();
                        break;
                    } else {
                        TreeNode curr = queue.poll();
                        if (curr.left != null) {
                            queue.offer(curr.left);
                        }
                        if (curr.right != null) {
                            queue.offer(curr.right);
                        }
                    }
                }
                k++;
            }

            return root;
        }




//        DFS

//        if (depth == 1) {
//            return new TreeNode(val, root, null);
//        } else {
//            dfs_addOneRow(root, val, depth, 1);
//            return root;
//        }
    }

    public void dfs_addOneRow(TreeNode curr, int val, int depth, int k) {
        if (curr == null) {
            return;
        }

        if (k == depth - 1) {
            TreeNode treeNode1 = new TreeNode(val, curr.left, null);
            TreeNode treeNode2 = new TreeNode(val, null, curr.right);
            curr.left = treeNode1;
            curr.right = treeNode2;
            return;
        }

        dfs_addOneRow(curr.left, val, depth, k + 1);
        dfs_addOneRow(curr.right, val, depth, k + 1);
    }


//    https://leetcode.com/problems/smallest-string-starting-from-leaf/?envType=daily-question&envId=2024-04-17
    String smallestString = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs_smallestFromLeaf(root, new StringBuilder());
        return smallestString;
    }

    public void dfs_smallestFromLeaf(TreeNode root, StringBuilder curString) {
        if (root == null) {
            return;
        }

        curString.insert(0, (char)(root.val + 'a'));

        if (root.left == null && root.right == null) {
            if (Objects.equals(smallestString, "") || smallestString.compareTo(curString.toString()) > 0) {
                smallestString = curString.toString();
            }
            return;
        }

        if (root.left != null) {
            dfs_smallestFromLeaf(root.left, curString);
            curString.deleteCharAt(0);
        }

        if (root.right != null) {
            dfs_smallestFromLeaf(root.right, curString);
            curString.deleteCharAt(0);
        }
    }

//    https://leetcode.com/problems/balanced-binary-tree/
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return heightTree(root) != -1;
    }

    public int heightTree(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = heightTree(root.left);
        int rightHeight = heightTree(root.right);

        if (leftHeight == -1 || rightHeight == -1)  return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
