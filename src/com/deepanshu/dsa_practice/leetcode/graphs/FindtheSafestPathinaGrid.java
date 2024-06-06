package com.deepanshu.dsa_practice.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class FindtheSafestPathinaGrid {
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(List.of(1, 0, 0));
        grid.add(List.of(0, 0, 0));
        grid.add(List.of(0, 0, 1));
        System.out.println(maximumSafenessFactor(grid));
    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        return 0;
    }
}
