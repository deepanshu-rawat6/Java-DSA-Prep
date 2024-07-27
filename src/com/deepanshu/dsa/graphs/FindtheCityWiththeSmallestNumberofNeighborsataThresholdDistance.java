package com.deepanshu.dsa.graphs;

import java.util.*;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static void dijkstra(List<List<Edge>> adjList, int src, int[] dis) {
        var pq = new PriorityQueue<Edge>((a,b) -> a.cost - b.cost);
        dis[src] = 0;

        pq.add(new Edge(src, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            for(Edge neighbor : adjList.get(edge.to)) {
                var newDist = edge.cost + neighbor.cost;
                if (newDist < dis[neighbor.to]) {
                    dis[neighbor.to] = newDist;
                    pq.add(new Edge(neighbor.to, dis[neighbor.to]));
                }
            }
        }

    }

    private static void floydWarshall(int[][] dist, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
//        Using Dijkstra's

//        int count = 0, cMin = n, res = -1;
//        List<List<Edge>> adjList = createAdjList(n, edges);
//
//        for (int i = 0; i < n; i++) {
//            int[] dis = new int[n];
//            Arrays.fill(dis, Integer.MAX_VALUE);
//            dijkstra(adjList, i, dis);
//
//            count = 0;
//
//            for (int j = 0; j < n; j++) {
//                if (dis[j] <= distanceThreshold) {
//                    count++;
//                }
//            }
//
//            if (count <= cMin) {
//                cMin = count;
//                res = i;
//            }
//        }
//
//        return res;


//        Using Floyd-Warshall

        var dist = new int[n][n];
        int count = 0, cMin = n, res = -1;
        var INF = (int)1e4 + 1;

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);

            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], cost = edge[2];
            dist[from][to] = cost;
            dist[to][from] = cost;
        }

//        System.out.println(Arrays.deepToString(dist));

        floydWarshall(dist, n);

//        System.out.println(Arrays.deepToString(dist));

        for (int i = 0; i < dist.length; i++) {
            count = 0;
            for (int j = 0; j < dist[0].length; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= cMin) {
                cMin = count;
                res = i;
            }
        }

        return res;
    }

    private static List<List<Edge>> createAdjList(int n, int[][] edges) {
        List<List<Edge>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Edge(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }

        return adjList;
    }

    public static void main(String[] args) {
//        int n = 4, distanceThreshold = 4;
//        int[][] edges = {
//                {0,1,3},
//                {1,2,1},
//                {1,3,4},
//                {2,3,1}
//        };

        int[][] edges = {
                {0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}
        };
        int n = 5, distanceThreshold = 2;

        System.out.println(findTheCity(n, edges, distanceThreshold));
    }
}

//class Solution {
//
//    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
//        // Adjacency list to store the graph
//        List<int[]>[] adjacencyList = new List[n];
//        // Matrix to store shortest path distances from each city
//        int[][] shortestPathMatrix = new int[n][n];
//
//        // Initialize adjacency list and shortest path matrix
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(shortestPathMatrix[i], Integer.MAX_VALUE); // Set all distances to infinity
//            shortestPathMatrix[i][i] = 0; // Distance to itself is zero
//            adjacencyList[i] = new ArrayList<>();
//        }
//
//        // Populate the adjacency list with edges
//        for (int[] edge : edges) {
//            int start = edge[0];
//            int end = edge[1];
//            int weight = edge[2];
//            adjacencyList[start].add(new int[] { end, weight });
//            adjacencyList[end].add(new int[] { start, weight }); // For undirected graph
//        }
//
//        // Compute shortest paths from each city using Dijkstra's algorithm
//        for (int i = 0; i < n; i++) {
//            dijkstra(n, adjacencyList, shortestPathMatrix[i], i);
//        }
//
//        // Find the city with the fewest number of reachable cities within the distance threshold
//        return getCityWithFewestReachable(
//                n,
//                shortestPathMatrix,
//                distanceThreshold
//        );
//    }
//
//    // Dijkstra's algorithm to find shortest paths from a source city
//    void dijkstra(
//            int n,
//            List<int[]>[] adjacencyList,
//            int[] shortestPathDistances,
//            int source
//    ) {
//        // Priority queue to process nodes with the smallest distance first
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) ->
//                (a[1] - b[1])
//        );
//        priorityQueue.add(new int[] { source, 0 });
//        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE); // Set all distances to infinity
//        shortestPathDistances[source] = 0; // Distance to source itself is zero
//
//        // Process nodes in priority order
//        while (!priorityQueue.isEmpty()) {
//            int[] current = priorityQueue.remove();
//            int currentCity = current[0];
//            int currentDistance = current[1];
//            if (currentDistance > shortestPathDistances[currentCity]) {
//                continue;
//            }
//
//            // Update distances to neighboring cities
//            for (int[] neighbor : adjacencyList[currentCity]) {
//                int neighborCity = neighbor[0];
//                int edgeWeight = neighbor[1];
//                if (
//                        shortestPathDistances[neighborCity] >
//                                currentDistance + edgeWeight
//                ) {
//                    shortestPathDistances[neighborCity] = currentDistance +
//                            edgeWeight;
//                    priorityQueue.add(
//                            new int[] {
//                                    neighborCity,
//                                    shortestPathDistances[neighborCity],
//                            }
//                    );
//                }
//            }
//        }
//    }
//
//    // Determine the city with the fewest number of reachable cities within the distance threshold
//    int getCityWithFewestReachable(
//            int n,
//            int[][] shortestPathMatrix,
//            int distanceThreshold
//    ) {
//        int cityWithFewestReachable = -1;
//        int fewestReachableCount = n;
//
//        // Count number of cities reachable within the distance threshold for each city
//        for (int i = 0; i < n; i++) {
//            int reachableCount = 0;
//            for (int j = 0; j < n; j++) {
//                if (i == j) {
//                    continue;
//                } // Skip self
//                if (shortestPathMatrix[i][j] <= distanceThreshold) {
//                    reachableCount++;
//                }
//            }
//            // Update the city with the fewest reachable cities
//            if (reachableCount <= fewestReachableCount) {
//                fewestReachableCount = reachableCount;
//                cityWithFewestReachable = i;
//            }
//        }
//        return cityWithFewestReachable;
//    }
//}
