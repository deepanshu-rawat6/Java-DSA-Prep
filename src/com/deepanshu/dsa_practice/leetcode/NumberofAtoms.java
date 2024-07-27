package com.deepanshu.dsa_practice.leetcode;

import java.util.*;

public class NumberofAtoms {
    public static void main(String[] args) {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }

    public static String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();

        int n = formula.length(), i = 0;

        while (i < n) {
            char chr = formula.charAt(i);
            i++;

            if (chr == '(') {
                stack.push(map);
                map = new HashMap<>();
            } else if (chr == ')') {
                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) val = val * 10 + formula.charAt(i++) - '0';
                if (val == 0) val = 1;
                if (!stack.isEmpty()) {
                    Map<String, Integer> temp = map;
                    map = stack.pop();
                    for (String key : temp.keySet()) {
                        map.put(key, map.getOrDefault(key, 0) + temp.get(key) * val);
                    }
                }
            } else {
                int j = i - 1;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(j, i);
                int val = 0;
                while(i < n && Character.isDigit(formula.charAt(i))) val = 10 * val + formula.charAt(i++) - '0';
                if (val == 0) val = 1;
                map.put(element, map.getOrDefault(element, 0) + val);
            }
        }

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String key : list) {
            sb.append(key);
            if (map.get(key) > 1) sb.append(map.get(key));
        }

        return sb.toString();
    }
}
