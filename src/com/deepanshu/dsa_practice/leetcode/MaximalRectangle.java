package com.deepanshu.dsa_practice.leetcode;

import com.deepanshu.dsa.stacks.NGindex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        List<Integer> res = new ArrayList<>();

        for (int j = 0; j < matrix[0].length; j++) {
            res.add(matrix[0][j] - '0');
        }

        int max = maxAreaHistogram(res);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    res.set(j, 0);
                } else {
                    res.set(j, res.get(j) + (matrix[i][j] - '0'));
                }
            }
            max = Math.max(max, maxAreaHistogram(res));
        }

        return max;
    }

    public static int maxAreaHistogram(List<Integer> heights) {
        List<Integer> width = calculateWidth(heights);

        List<Integer> area = new ArrayList<>();

        for (int i = 0; i < heights.size(); i++) {
            area.add(i, heights.get(i) * width.get(i));
        }

        return Collections.max(area);
    }

    public static List<Integer> nearestSmallestToRight(List<Integer> heights) {
        Stack<NGindex<Integer,Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = heights.size() - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(heights.size());
            } else if (stack.peek().getKey() < heights.get(i)) {
                list.add(stack.peek().getValue());
            } else if (!stack.isEmpty() && stack.peek().getKey() >= heights.get(i)) {
                while (!stack.isEmpty() && stack.peek().getKey() >= heights.get(i)) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    list.add(heights.size());
                } else {
                    list.add(stack.peek().getValue());
                }
            }

            stack.push(new NGindex<>(heights.get(i), i));
        }

        Collections.reverse(list);

        return list;
    }

    public static List<Integer> nearestSmallestToLeft(List<Integer> heights) {
        Stack<NGindex<Integer,Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= heights.size() - 1; i++) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.peek().getKey() < heights.get(i)) {
                list.add(stack.peek().getValue());
            } else if (!stack.isEmpty() && stack.peek().getKey() >= heights.get(i)) {
                while (!stack.isEmpty() && stack.peek().getKey() >= heights.get(i)) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek().getValue());
                }
            }

            stack.push(new NGindex<>(heights.get(i), i));
        }

        return list;
    }

    public static List<Integer> calculateWidth(List<Integer> heights) {
        List<Integer> width = new ArrayList<>();

        List<Integer> right = nearestSmallestToRight(heights);
        List<Integer> left = nearestSmallestToLeft(heights);

//        System.out.println(right);
//        System.out.println(left);

        for (int i = 0; i < heights.size(); i++) {
            width.add(i,right.get(i) - left.get(i) - 1);
        }

//        System.out.println(width);

        return width;
    }

    public static int largestRectangleArea(List<Integer> heights) {
        int max = 0;

        List<Integer> widths = calculateWidth(heights);
        System.out.println(widths);
        List<Integer> area = new ArrayList<>();

        for (int i = 0; i < heights.size(); i++) {
            area.add(heights.get(i) * widths.get(i));
        }

        return Collections.max(area);
    }
}
