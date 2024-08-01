package com.deepanshu.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberofWaystoArriveatDestination {
    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

//        @Override
//        public int compareTo(Node other) {
//            return Integer.compare(this.cost, other.cost);
//        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
                {0,6,7},
                {0,1,2},
                {1,2,3},
                {1,3,3},
                {6,3,3},
                {3,5,1},
                {6,5,1},
                {2,5,1},
                {0,4,5},
                {4,6,2}
        };

        System.out.println(countPaths(n, roads));
    }

    public static int countPaths(int n, int[][] roads) {
        List<List<Node>> adjList = new ArrayList<>();

        setupGraph(n, roads, adjList);

        System.out.println(adjList);

        return dijkstra(n, adjList);
    }

    private static void setupGraph(int n, int[][] roads, List<List<Node>> adjList) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adjList.get(road[0]).add(new Node(road[1], road[2]));
            adjList.get(road[1]).add(new Node(road[0], road[2]));
        }
    }

    private static int dijkstra(int n, List<List<Node>> adjList) {
        var INF = (int)1e9 + 7;
        var time = new int[n];
        var count = new int[n];
        var visted = new boolean[n];

        Arrays.fill(time, 0);
        Arrays.fill(count, 1);
        Arrays.fill(visted, false);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()) {
            var node = pq.poll();

            if (time[node.to] < node.cost) {
                continue;
            }

            visted[node.to] = true;

            for (var neighbor : adjList.get(node.to)) {
                if (visted[neighbor.to]) {
                    continue;
                }
                if (time[neighbor.to] == 0 || time[neighbor.to] >= time[node.to] + neighbor.cost) {
                    if (time[neighbor.to] == time[node.to] + neighbor.cost) {
                        count[neighbor.to] = (count[node.to] + count[neighbor.to]) % INF;
                    } else {
                        time[neighbor.to] = time[node.to] + neighbor.cost;
                        count[neighbor.to] = count[node.to];
                        pq.offer(new Node(neighbor.to, time[neighbor.to]));
                    }
                }
            }
        }

        return count[n - 1];
    }
}
