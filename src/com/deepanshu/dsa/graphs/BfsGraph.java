package com.deepanshu.dsa.graphs;

import java.util.*;

public class BfsGraph {
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {1, 4},
                {3, 4},
                {4, 5}
        };

        int n = 5;

        traverseGraph(n, edges);
    }

    public static void traverseGraph(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        setupGraph(n, edges, adjList);

        var prev = bfs(adjList, n);

        var path = reconstructPath(n, prev);

        System.out.println(path);
    }

    private static List<Integer> reconstructPath(int e, int[] prev) {
        var path = new ArrayList<Integer>();

        for (var at = e; at != 0; at = prev[at]) {
            path.add(at);
        }

        Collections.reverse(path);

        if (path.get(0) == 1) {
            return path;
        }

        return new ArrayList<>();
    }

    private static void setupGraph(int n, int[][] edges, List<List<Integer>> adjList) {
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    private static int[] bfs(List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        var visited = new boolean[n + 1];
        visited[1] = true;

        var prev = new int[n + 1];

        while (!queue.isEmpty()) {
            var node = queue.poll();
            var neighbors = graph.get(node);

            for (var neighbor : neighbors) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    prev[neighbor] = node;
                }
            }
        }

        return prev;
    }
}
