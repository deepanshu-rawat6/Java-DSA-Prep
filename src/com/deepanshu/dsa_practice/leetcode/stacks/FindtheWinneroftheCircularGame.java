package com.deepanshu.dsa_practice.leetcode.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class FindtheWinneroftheCircularGame {
    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5));
    }
    public static  int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        System.out.println(queue);

        while (queue.size() > 1) {

            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.remove());
            }

            queue.remove();
        }

        return queue.peek();



//        return helper(n, k) + 1;
    }

    private static  int helper(int n, int k) {
        if (n == 1) return 0;

        return (helper(n - 1,  k) + k) % n;
    }
}
