package com.deepanshu.dsa_practice.leetcode.graphs;

import java.util.*;

public class BuildaMatrixWithConditions {
    public static void main(String[] args) {
        int k = 3;
        int[][] rowConditions = {{1,2},{3,2}}, colConditions = {{2,1},{3,2}};

        System.out.println(Arrays.deepToString(buildMatrix(k, rowConditions, colConditions)));
    }

    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] res = new int[k][k];

        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);

        if (rowOrder.size() < k || colOrder.size() < k) {
            return new int[0][0];
        }

        // System.out.println(rowOrder);
        // System.out.println(colOrder);

        for (int row = 0; row < k; row++) {
            int val = rowOrder.get(row);
            int col = colOrder.indexOf(val);
            res[row][col] = val;
        }

        return res;
    }

    private static List<Integer> topologicalSort(int k, int[][] conditions) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] in_degree = new int[k];

        for (int[] condition : conditions) {
            int a = condition[0];
            int b = condition[1];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
            in_degree[b - 1]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (in_degree[i] == 0) queue.offer(i + 1);
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int at = queue.poll();
            order.add(at);

            if (graph.containsKey(at)) {
                for (int to : graph.get(at)) {
                    in_degree[to - 1]--;

                    if (in_degree[to - 1] == 0) queue.offer(to);
                }
            }
        }

        return order;
    }
}
