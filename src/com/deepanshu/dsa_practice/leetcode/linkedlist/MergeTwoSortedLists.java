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


    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists,0,lists.length - 1);
    }

    public static ListNode partion(ListNode[] lists, int s, int e){
        if(s == e)  return lists[s];
        if(s < e){
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists,q + 1, e);
            return merge(l1, l2);
        } else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}
