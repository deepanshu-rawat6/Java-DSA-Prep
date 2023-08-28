package com.deepanshu.dsa.binary_search;

public class RotatedBinarySearchWithDuplicateValues {
    public static void main(String[] args) {
        int[] arr = {2,9,2,2,2};
        System.out.println(searchRotatedArray(arr, 9));
    }

    public static int searchRotatedArray(int[] arr, int target) {
        int pivot = findPivotWithDuplicates(arr);

        if (pivot == -1) {
            return searchBS(arr, 0, arr.length - 1, target);
        }

        if (arr[pivot] == target) {
            return pivot;
        }

        if (target >= arr[0]) {
            return searchBS(arr, 0, pivot - 1, target);
        }

        return searchBS(arr, pivot + 1, arr.length - 1, target);
    }

    public static int findPivotWithDuplicates(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (mid < e && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > s && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } if (arr[mid] == arr[s] && arr[mid] == arr[e]) {
//                skipping duplicates
//                NOTE: what if these elements at the start and end were the pivot elements?
//                checking if start is pivot
                if (arr[s] >  arr[s + 1]) {
                    return s;
                }
                s++;

//                checking if end is pivot
                if (arr[e] < arr[e - 1]) {
                    return e - 1;
                }
                e--;
            }
//            left side is sorted, so pivot should be on the right side
            else if (arr[s] < arr[mid] || (arr[s] == arr[mid] && arr[mid] > arr[e])) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static int searchBS(int[] arr, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] >  target) {
                e = mid - 1;
            } else if (arr[mid] < target) {
                s = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
