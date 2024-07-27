package com.deepanshu.dsa.graphs;

import com.deepanshu.codingContests.CF_Starters144D.Codechef;
import com.deepanshu.java.oops.access.A;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.*;

public class DijkstraSSSP {
    static class Pair {
        public int key;
        public int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            din.close();
        }
    }

    static class Node implements Comparable<Node> {
        int edge;
        int cost;

        Node(int edge) {
            this.edge = edge;
        }

        Node(int edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws  IOException {
       Reader in = new Reader();

        Map<Integer, Map<Integer, Integer>> adjList = new HashMap<>();

        addEdge(adjList, 0, 1, 4);
        addEdge(adjList, 0, 2, 1);
        addEdge(adjList, 1, 3, 1);
        addEdge(adjList, 2, 1, 2);
        addEdge(adjList, 2, 3, 5);
        addEdge(adjList, 3, 4, 3);

        int n = 5;

        int s = 0;
        int e = 4;

        List<Node> path = findShortestPath(adjList, n, s, e);

        for (Node node : path) {
            System.out.println("Node: " + node.edge + " cost: " + node.cost);
        }
    }


    private static void lazyDijkstra(Map<Integer, Map<Integer, Integer>> adjList, int n, int s) {
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // source is 0, and dist is 0
        pq.offer(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currE = node.edge;

            visited[currE] = true;

//            Optimization to skip, to ignore stale (indx, dist) pairs in our PQ
//            Skip the nodes which have better path routing through other nodes before we start processing this node
//            if (dist[currE] < node.cost) {
//                continue;
//            }

            for (Map.Entry<Integer, Integer> neighbor : adjList.getOrDefault(currE, new HashMap<>()).entrySet()) {
                int neighborV = neighbor.getKey();
                int cost = neighbor.getValue();

                if (!visited[neighborV] && dist[currE] + cost < dist[neighborV]) {
                    dist[neighborV] = dist[currE] + cost;
                    pq.offer(new Node(neighborV, dist[neighborV]));
                }
            }
        }

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Node " + i + " : " + dist[i]);
        }
    }

    private static List<Node> findShortestPath(Map<Integer, Map<Integer, Integer>> adjList, int n, int s, int e) {
        Object[] ans = lazyDijkstraPath(adjList, n, s);
        int[] dist = (int[]) ans[0];
        Node[] prev = (Node[]) ans[1];

        for (int i = 1; i < n; i++) {
            System.out.println("Prev Node " + prev[i].edge + " : " + prev[i].cost);
        }

        if (dist[e] == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }

        List<Node> path = new ArrayList<>();
        Node at = new Node(e);
        int indx = n - 1;
        while (at != null) {
            path.add(at);
            at = prev[indx];
            indx--;
        }

        Collections.reverse(path);

        return path;
    }

    private static Object[] lazyDijkstraPath(Map<Integer, Map<Integer, Integer>> adjList, int n, int s) {
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Node[] prev = new Node[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, null);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // source is 0, and dist is 0
        pq.offer(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currE = node.edge;

            visited[currE] = true;

//            Optimization to skip, to ignore stale (indx, dist) pairs in our PQ
//            Skip the nodes which have better path routing through other nodes before we start processing this node
            if (dist[currE] < node.cost) {
                continue;
            }

            for (Map.Entry<Integer, Integer> neighbor : adjList.getOrDefault(currE, new HashMap<>()).entrySet()) {
                int neighborV = neighbor.getKey();
                int cost = neighbor.getValue();

                if (!visited[neighborV] && dist[currE] + cost < dist[neighborV]) {
                    prev[neighborV] = node;
                    dist[neighborV] = dist[currE] + cost;
                    pq.offer(new Node(neighborV, dist[neighborV]));
                }
            }
        }

//        System.out.println("Shortest distances from node 0:");
//        for (int i = 1; i < 5; i++) {
//            System.out.println("Node " + i + " : " + dist[i]);
//            System.out.println("Prev Node " + ": " + prev[i].edge + " -> " + prev[i].cost);
//        }

//        System.out.println(Arrays.toString(prev));

        return new Object[]{dist, prev};

    }

    private static void addEdge(Map<Integer, Map<Integer, Integer>> adjList, int from, int to, int cost) {
        adjList.computeIfAbsent(from, k -> new HashMap<>()).put(to, cost);
    }
}
