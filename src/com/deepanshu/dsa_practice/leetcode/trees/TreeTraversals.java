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
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                currentLevel.add(queue.poll().val);
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
}
