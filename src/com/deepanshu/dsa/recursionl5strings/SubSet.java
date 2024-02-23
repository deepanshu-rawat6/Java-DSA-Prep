package com.deepanshu.dsa.recursionl5strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
//        List<List<Integer>> ans = subset(arr);

        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();
//        subsetRecursionDup(ans, new ArrayList<>(), arr, 0);

        subSet(arr, 0, ans, new ArrayList<>());
        System.out.println(ans);
//        System.out.println(ans);
//        int[] arr1={2,1,2};
//        List<List<Integer>> ans1=subsetDuplicate(arr1);
//        System.out.println(ans1);

//        int[] nums = {1,2,3};
//
//        List<List<Integer>> ans = new ArrayList<>();
//
//        if (nums == null || nums.length == 0) {
//            System.out.println(ans);
//        }
//
//        Arrays.sort(nums);
//
//        subsetRecursion(ans, new ArrayList<>(), nums, 0);
//
//        System.out.println(ans);
    }
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : arr){
            int n = outer.size();
            for(int i = 0; i < n ; i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

    static void subsetRecursion(List<List<Integer>> ans, List<Integer> list, int[] nums, int x) {
        if (x >= nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[x]);
        subsetRecursion(ans, list, nums, x + 1);

        list.remove(list.size() - 1);
        subsetRecursion(ans, list, nums, x + 1);
    }

    static List<List<Integer>> subsetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            start = 0;
            if(i > 0 && arr[i - 1] == arr[i]){
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for(int j = start; j < n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }

//    sorted!
    static void subsetRecursionDup(List<List<Integer>> ans, List<Integer> list, int[] nums, int x) {
        ans.add(new ArrayList<>(list));

        for (int i = x; i < nums.length; i++) {
            if (i > x && nums[i] == nums[i - 1]) continue;

            list.add(nums[i]);
            subsetRecursionDup(ans, list, nums, x + 1);

            list.remove(list.size() - 1);
        }

//        if (x >= nums.length) {
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//
//        if (x > 0 && nums[x] == nums[x - 1]) {
//            return;
//        }
//
//        list.add(nums[x]);
//        subsetRecursionDup(ans, list, nums, x + 1);
//
//        list.remove(list.size() - 1);
//        subsetRecursionDup(ans, list, nums, x + 1);
    }

    public static void subSet(int[] nums, int index, List<List<Integer>> ans, List<Integer> list) {
        ans.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subSet(nums, i + 1, ans, list);
            list.remove(list.size() - 1);
        }
    }
}
