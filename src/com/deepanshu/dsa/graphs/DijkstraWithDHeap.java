package com.deepanshu.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class DijkstraWithDHeap {

    public static class Edge {
        int to;
        double cost;

        public Edge(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private final int n;
    private int edgeCount;
    private double[] distTo;
    private Integer[] prev;
    private List<List<Edge>> graph;

    public DijkstraWithDHeap(int n) {
        this.n = n;
        createEmptyGraph();
    }

    private void createEmptyGraph() {
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, double cost) {
        edgeCount++;
        graph.get(from).add(new Edge(to, cost));
    }

    public List<List<Edge>> getGraph() {
        return graph;
    }

//    public double dijkstra(int start, int end) {
//
//    }
}
