package com.deepanshu.dsa_practice.leetcode;

import java.util.*;

public class AlienDict {

    public static String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }


        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];


            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int length = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;

            for (int j = 0; j < length; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    foundDifference = true;
                    break;
                }
            }

            if (!foundDifference && word1.length() > word2.length()) {
                return "";
            }
        }


        StringBuilder result = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        Set<Character> cycle = new HashSet<>();

        for (char c : graph.keySet()) {
            if (dfs(c, graph, visited, cycle, result)) {
                return "";
            }
        }

        return result.reverse().toString();
    }

    private static boolean dfs(char c, Map<Character, Set<Character>> graph, Set<Character> visited, Set<Character> cycle, StringBuilder result) {
        if (cycle.contains(c)) {
            return true;
        }
        if (visited.contains(c)) {
            return false;
        }

        visited.add(c);
        cycle.add(c);

        for (char next : graph.get(c)) {
            if (dfs(next, graph, visited, cycle, result)) {
                return true;
            }
        }

        cycle.remove(c);
        result.append(c);
        return false;
    }

    public static void main(String[] args) {
        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Order of characters: " + alienOrder(words1));

        String[] words2 = {"zxy", "zxw", "zy", "zz"};
        System.out.println("Order of characters: " + alienOrder(words2));
    }
}

