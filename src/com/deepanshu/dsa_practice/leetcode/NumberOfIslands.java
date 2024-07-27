package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {
    static class Pair {
        int key;
        int val;

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null) return 0;

        int m = grid.length, n = grid[0].length, count = 0;
        List<List<Integer>> adj_vis = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            adj_vis.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                adj_vis.get(i).add(0);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && adj_vis.get(i).get(j) == 0) {
                    bfs(grid, i, j, m, n, adj_vis);
                    count++;
                }
            }
        }

        return count;
    }



    private static void bfs(char[][] grid, int row, int col, int m, int n, List<List<Integer>> adj_vis) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        adj_vis.get(row).set(col, 1);

        while (!queue.isEmpty()) {
            int i = queue.peek().getKey();
            int j = queue.peek().getVal();
            queue.poll();

            if (i - 1 >= 0 && grid[i - 1][j] == '1' && adj_vis.get(i - 1).get(j) != 1) {
                adj_vis.get(i - 1).set(j, 1);
                queue.add(new Pair(i - 1, j));
            }
            if (i + 1 < m && grid[i + 1][j] == '1' && adj_vis.get(i + 1).get(j) != 1) {
                adj_vis.get(i + 1).set(j, 1);
                queue.add(new Pair(i + 1, j));
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1' && adj_vis.get(i).get(j - 1) != 1) {
                adj_vis.get(i).set(j - 1, 1);
                queue.add(new Pair(i, j - 1));
            }
            if (j + 1 < n && grid[i][j + 1] == '1' && adj_vis.get(i).get(j + 1) != 1) {
                adj_vis.get(i).set(j + 1, 1);
                queue.add(new Pair(i, j + 1));
            }
        }
    }
}
