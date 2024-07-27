package com.deepanshu.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};

        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> adjList = createAdjList(n, times);

        int max = Integer.MIN_VALUE;

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;

        dijkstra(adjList, k, dis, n);

        for (int i = 0; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) continue;
            max = Math.max(max, dis[i]);
        }

        return max;
    }

    private static List<List<Edge>> createAdjList(int n, int[][] edges) {
        List<List<Edge>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }

        return adjList;
    }

    private static void dijkstra(List<List<Edge>> adjList, int src, int[] dis, int n) {
        var pq = new PriorityQueue<Edge>((a,b) -> a.cost - b.cost);
        var visted = new Boolean[n + 1];

        Arrays.fill(visted, false);

        pq.offer(new Edge(src, 0));
        while (!pq.isEmpty()) {
            var edge = pq.poll();

            if (dis[edge.to] < edge.cost) {
                continue;
            }

            visted[edge.to] = true;

            for (var neighbor : adjList.get(edge.to)) {
                if (visted[neighbor.to]) {
                    continue;
                }
                var newDist = dis[edge.to] + neighbor.cost;
                if (newDist < dis[neighbor.to]) {
                    dis[neighbor.to] = newDist;
                    pq.offer(new Edge(neighbor.to, newDist));
                }
            }
        }
    }
}
