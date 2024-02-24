package com.deepanshu.dsa_practice.leetcode.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode finalList = new ListNode();
//
//        if(list1 == null) {
//            return list2;
//        }
//
//        if (list2 == null) {
//            return list1;
//        }
//
//        while (list1.next != null && list2.next != null) {
//            if (list1.val > list2.val) {
//                finalList.val = list2.val;
//                finalList = finalList.next;
//                list2 = list2.next;
//            } else {
//                finalList.val = list1.val;
//                finalList = finalList.next;
//                list1 = list1.next;
//            }
//        }
//
//        while (list1.next != null) {
//            finalList.val = list1.val;
//            finalList = finalList.next;
//            list1 = list1.next;
//        }
//
//        while (list2.next != null) {
//            finalList.val = list2.val;
//            finalList = finalList.next;
//            list2 = list2.next;
//        }
//
//        return finalList;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
