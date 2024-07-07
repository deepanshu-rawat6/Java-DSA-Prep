package com.deepanshu.dsa_practice.leetcode.greedy;

import java.util.*;

class Pair<K, V> {
    K key;
    V value;

    public Pair(K key,V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10} , profit = {10, 20, 30, 40, 50} , worker = {4, 5, 6, 7};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> difficultyWithProfits = new ArrayList<>();
        int i = 0, best = 0, res = 0;

        for (int j = 0; j < difficulty.length; j++) {
            difficultyWithProfits.add(new Pair<>(difficulty[j], profit[j]));
        }

        difficultyWithProfits.sort(Comparator.comparing(Pair::getKey));

        Arrays.sort(worker);

        for (int ability : worker) {
            while (i < profit.length && ability >= difficultyWithProfits.get(i).getKey()) {
                best = Math.max(difficultyWithProfits.get(i++).getValue(), best);
            }
            res += best;
        }

        return res;
    }
}
