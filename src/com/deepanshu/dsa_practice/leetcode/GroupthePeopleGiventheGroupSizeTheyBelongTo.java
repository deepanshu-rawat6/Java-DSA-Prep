package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
//        int[] groupSizes = {2,1,3,3,3,2};
        System.out.println(groupThePeople(groupSizes));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if(!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
        }

        List<List<Integer>> list = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            int groupSize = entry.getKey();
            ArrayList<Integer> members = entry.getValue();

            for (int i = 0; i < members.size(); i += groupSize) {
                List<Integer> group = new ArrayList<>(members.subList(i, i + groupSize));
                list.add(group);
            }
        }

        return list;
    }
}
