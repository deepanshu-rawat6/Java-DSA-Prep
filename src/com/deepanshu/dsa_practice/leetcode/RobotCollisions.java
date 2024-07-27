package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {
    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> indx = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            indx.add(i);
        }

        indx.sort(Comparator.comparingInt(a -> positions[a]));

        Stack<Integer> stack = new Stack<>();
        for (int i : indx) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && healths[i] > 0) {
                if (healths[stack.peek()] > healths[i]) {
                    healths[stack.peek()] -= 1;
                    healths[i] = 0;
                } else if (healths[stack.peek()] < healths[i]) {
                    healths[stack.pop()] = 0;
                    healths[i] -= 1;
                } else {
                    healths[i] = 0;
                    healths[stack.pop()] = 0;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i : healths) {
            if (i != 0) res.add(i);
        }

        return res;
    }
}
