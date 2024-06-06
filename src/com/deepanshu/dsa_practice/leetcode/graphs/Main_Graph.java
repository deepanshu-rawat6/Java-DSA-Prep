package com.deepanshu.dsa_practice.leetcode.graphs;

public class Main_Graph {
    public static void main(String[] args) {
        graphTraversals graphTraversals = new graphTraversals();
//        int[][] grid = {
//                {0,1,0,0},
//                {1,1,1,0},
//                {0,1,0,0},
//                {1,1,0,0}
//        };
//        System.out.println(graphTraversals.islandPerimeter(grid));

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(graphTraversals.numIslands(grid));
    }
}
