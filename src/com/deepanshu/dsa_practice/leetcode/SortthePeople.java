package com.deepanshu.dsa_practice.leetcode;

import java.util.*;

public class SortthePeople {

    static class Pair {
        private String name;
        private int height;

        public Pair(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public int getHeight() {
            return height;
        }
    }

    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};

        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        List<Pair> combined = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            combined.add(new Pair(names[i], heights[i]));
        }

        System.out.println(combined);

        combined.sort((a, b) -> b.getHeight() - a.getHeight());

        String[] sortedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            sortedNames[i] = combined.get(i).getName();
        }

        return sortedNames;
    }
}
