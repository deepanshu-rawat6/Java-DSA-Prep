package com.deepanshu.dsa_practice.leetcode.graphs;

public class graphTraversals {

//    https://leetcode.com/problems/island-perimeter/?envType=daily-question&envId=2024-04-18

    public int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += dfs_islandPerimeter(grid, i, j, rows, cols);
                }
            }
        }

        return perimeter;
    }

    public int dfs_islandPerimeter(int[][] grid, int i, int j, int rows, int cols) {
        if (i >= rows ||  j >= cols || i < 0 || j < 0 || grid[i][j] == 0) {
            return 1;
        }

        if (grid[i][j] == -1) {
            return 0;
        }

        grid[i][j] = -1;

        return (dfs_islandPerimeter(grid, i, j + 1, rows, cols) +
                dfs_islandPerimeter(grid ,i + 1, j, rows, cols) +
                dfs_islandPerimeter(grid, i, j - 1, rows, cols) +
                dfs_islandPerimeter(grid, i - 1, j, rows, cols)
        );
    }

//    https://leetcode.com/problems/number-of-islands/?envType=daily-question&envId=2024-04-19

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs_numIslands(grid, i, j, rows, cols);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs_numIslands(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') return;

        grid[i][j] = '0';

        dfs_numIslands(grid, i + 1, j, rows, cols);
        dfs_numIslands(grid, i - 1, j, rows, cols);
        dfs_numIslands(grid, i, j + 1, rows, cols);
        dfs_numIslands(grid, i, j - 1, rows, cols);
    }
}
