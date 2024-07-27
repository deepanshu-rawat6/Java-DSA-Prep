package com.deepanshu.dsa.graphs;

import java.util.Arrays;

public class MinimumCosttoConvertStringI {
    public static void main(String[] args) {
        String source = "abcd", target = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b','c','b','e','b','e'};
        int[] cost = {2,5,5,1,2,20};

        System.out.println(minimumCost(source, target, original, changed, cost));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        var dist = new long[26][26];
        long res = 0;
        var INF = (long)1e9 + 7;

        setup(dist, original, changed, cost, INF);

        floydWarshall(dist);

        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            char chr = target.charAt(i);

            if (ch == chr) continue;
            var s = ch - 'a';
            var t = chr - 'a';
            if (dist[s][t] >= INF) {
                return -1;
            }
            res += dist[s][t];
        }

        return res;
    }

    private static void setup(long[][] dist, char[] original, char[] changed, int[] cost, long INF) {

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);

            dist[i][i] = 0;
        }

       for (int i = 0; i < original.length; i++) {
           var oIndx = original[i] - 'a';
           var cIndx = changed[i] - 'a';

           dist[oIndx][cIndx] = Math.min(dist[oIndx][cIndx], (long)cost[i]);
       }
    }

    private static void floydWarshall(long[][] dist) {
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
