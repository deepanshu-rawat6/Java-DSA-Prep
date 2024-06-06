package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        int[] deck = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < deck.length; i++) {
            deque.add(i);
        }

        for (int i : deck) {
            int temp = deque.removeFirst();
            result[temp] = i;
            if (!deque.isEmpty()) {
                deque.add(deque.removeFirst());
            }
        }

        return result;
    }
}
