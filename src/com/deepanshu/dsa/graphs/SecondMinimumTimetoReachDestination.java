package com.deepanshu.dsa.graphs;

import java.util.*;

public class SecondMinimumTimetoReachDestination {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { {1,2},{1,3},{1,4},{3,4},{4,5}};
        int time = 3, change = 5;

//        int n = 2;
//        int[][] edges = { {1,2}};
//        int time = 1, change = 2;

        System.out.println(secondMinimum(n, edges, time, change));
    }

    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adjList = new ArrayList<>();

        setupGraph(n, edges, adjList);

        System.out.println(adjList);

        return bfs(n, adjList, time, change);
    }

    private static void setupGraph(int n, int[][] edges, List<List<Integer>> adjList) {
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    private static int bfs(int n, List<List<Integer>> adjList, int time, int change) {
        var dist1 = new int[n + 1];
        var dist2 = new int[n + 1];

        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        dist1[1] = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            var node = temp[0];
            var freq = temp[1];

            int timeTN = freq == 1 ? dist1[node] : dist2[node];

            if ((timeTN / change) % 2 == 1) {
                timeTN += change - (timeTN % change) + time;
            } else {
                timeTN += time;
            }

            if (node >= adjList.size() || adjList.get(node) == null || adjList.get(node).isEmpty()) {
                continue;
            }

            for (var neighbor : adjList.get(node)) {
                if (dist1[neighbor] == -1) {
                    dist1[neighbor] = timeTN;
                    queue.offer(new int[]{ neighbor, 1});
                } else if (dist2[neighbor] == -1 && dist1[neighbor] != timeTN) {
                    if (neighbor == n) return timeTN;

                    dist2[neighbor] = timeTN;
                    queue.offer(new int[]{ neighbor, 2});
                }
            }

            System.out.println("Dist1 : " + Arrays.toString(dist1));
            System.out.println("Dist2 : " + Arrays.toString(dist2));
        }

        return 0;
    }
}
