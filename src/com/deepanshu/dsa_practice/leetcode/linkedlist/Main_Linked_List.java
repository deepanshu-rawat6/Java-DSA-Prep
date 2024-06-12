package com.deepanshu.dsa_practice.leetcode.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class Main_Linked_List {

    public static ListNode head1 = null;

    public static void main(String[] args) {
        ListNode list = new ListNode();
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        CycleProblemsInLinkedList cycleProblemsInLinkedList = new CycleProblemsInLinkedList();
        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        MoreOnLinkedLists moreOnLinkedLists = new MoreOnLinkedLists();

        /*

         **************** Basics : Insertion, Deletion and Display ****************

         */

//        ListNode list = new ListNode();


//        head = list.insertAtNthPos(head, 10, 0);
//        head = list.insertAtNthPos(head, 30, list.size);
//        head = list.insertAtNthPos(head, 20, 1);
//        head.displayLL(head);
//        head = list.deleteAtNthPos(head, 1);
//        head.displayLL(head);


        /*

         **************** Reverse a linked list ****************

         */
//        ListNode list = new ListNode();


//        head = reverseLinkedList.reverseList(head);
//        list.displayLL(head);


        /*

        **************** Merge Two Sorted Lists ****************

         */
//        ListNode list = new ListNode();

//        ListNode list1 = new ListNode();
//        ListNode head2 = null;
//        head2 = list1.insertAtNthPos(null, 1, 0);
//        head2 = list1.insertAtTail(head2, 2);
//        head2 = list1.insertAtTail(head2, 4);
//        head2.displayLL(head2);
//
//        ListNode list2 = new ListNode();
//        ListNode head2 = null;
//        head2 = list2.insertAtNthPos(null, 1, 0);
//        head2 = list2.insertAtTail(head2, 3);
//        head2 = list2.insertAtTail(head2, 4);
//        head2.displayLL(head2);
//
//        head = mergeTwoSortedLists.mergeTwoLists(head2, head2);
//        head.displayLL(head);

        /*

         **************** Cycle related questions linked list ****************

         */

//        ListNode list = new ListNode();


//        head = list.insertAtNthPos(null, 1, 0);
//        head = list.insertAtHead(head, 2);
//        head = list.insertAtHead(head, 3);
//        head = list.insertAtHead(head, 4);
//        head = list.insertAtHead(head, 5);
//
//        list.displayLL(head);
//        cycleProblemsInLinkedList.addCycle(head, 2);
//
//        list.displayLL(head);
//
//        System.out.println("\nDoes the linked list have a cycle: " + cycleProblemsInLinkedList.hasCycle(head));
//
//        System.out.println("\nLength of the cycle: " + cycleProblemsInLinkedList.lengthCycle(head));
//
//        head = cycleProblemsInLinkedList.detectCycle(head);
        /*

         **************** Remove Nth Node From End of List ****************

         */

//        ListNode list = new ListNode();

//        head = list.insertAtNthPos(null, 1, 0);
//        head = list.insertAtTail(head, 2);
//        head = list.insertAtTail(head, 3);
//        head = list.insertAtTail(head, 4);
//        head = list.insertAtTail(head, 5);
//
//        list.displayLL(head);
//
//        head = removeNthNodeFromEndofList.removeNthFromEnd(head,2);
//        list.displayLL(head);

        /*

         **************** Add Two Numbers ****************

         */

//        ListNode list1 = new ListNode();
//
//        ListNode head2 = null;

//        head2 = list1.insertAtNthPos(null, 2, 0);
//        head2 = list1.insertAtTail(head2, 4);
//        head2 = list1.insertAtTail(head2, 9);

//        head2 = list1.insertAtNthPos(null, 9, 0);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);
//
//        head2.displayLL(head2);
//
//        ListNode list2 = new ListNode();
//        ListNode head2 = null;

//        head2 = list2.insertAtNthPos(null, 5, 0);
//        head2 = list2.insertAtTail(head2, 6);
//        head2 = list2.insertAtTail(head2, 4);
//        head2 = list2.insertAtTail(head2, 9);

//        head2 = list2.insertAtNthPos(null, 9, 0);
//        head2 = list2.insertAtTail(head2, 9);
//        head2 = list2.insertAtTail(head2, 9);
//        head2 = list2.insertAtTail(head2, 9);
//
//        head2.displayLL(head2);
//
//       head = addTwoNumbers.addTwoNumbers(head2, head2);
//       head.displayLL(head);

        /*

         **************** More On Linked Lists ****************

         */
//
//        head = list.insertAtNthPos(null, -1, 0);
//        head = list.insertAtTail(head, 5);
//        head = list.insertAtTail(head, 3);
//        head = list.insertAtTail(head, 4);
//        head = list.insertAtTail(head, 0);
////        head = list.insertAtTail(head, 6);
//
////        head = moreOnLinkedLists.middleNode(head);
//
//        head = moreOnLinkedLists.sortList(head);
//
//        list.displayLL(head);


//        Delete the Middle Node of a Linked List

        /*

         **************** Delete the Middle Node of a Linked List ****************

         */

//        head = list.insertAtNthPos(head, 1, 0);
//        head = list.insertAtTail(head, 3);
//        head = list.insertAtTail(head, 4);
//        head = list.insertAtTail(head, 7);
//        head = list.insertAtTail(head, 1);
//        head = list.insertAtTail(head, 2);
//        head = list.insertAtTail(head, 6);

//        list.displayLL(head);
//
//        head = cycleProblemsInLinkedList.deleteMiddle(head);
//
//        list.displayLL(head);

        /*

         **************** Remove Duplicates from Sorted List ****************

         */

//        head = list.insertAtNthPos(head, 1, 0);
//        head = list.insertAtTail(head, 1);
//        head = list.insertAtTail(head, 1);
//        head = list.insertAtTail(head, 2);
//        head = list.insertAtTail(head, 3);
////        head = list.insertAtTail(head, 2);
////        head = list.insertAtTail(head, 6);
//
//        list.displayLL(head);
//
//        head = moreOnLinkedLists.deleteDuplicates(head);
//
//        list.displayLL(head);


        /*

         **************** Reorder List ****************

         */

//        head = list.insertAtNthPos(head, 1, 0);
//        head = list.insertAtTail(head, 2);
//        head = list.insertAtTail(head, 3);
//        head = list.insertAtTail(head, 4);
//        head = list.insertAtTail(head, 5);
//
//        moreOnLinkedLists.reorderList(head);


        /*

         **************** Palindrome List ****************

         */


//        head = list.insertAtNthPos(head, 1, 0);
//        head = list.insertAtTail(head, 2);
//        head = list.insertAtTail(head, 3);
//        head = list.insertAtTail(head, 4);
//        head = list.insertAtTail(head, 5);

//        head = list.insertAtNthPos(head, 1, 0);
//        head = list.insertAtTail(head, 2);
//        head = list.insertAtTail(head, 3);
//        head = list.insertAtTail(head, 2);
//        head = list.insertAtTail(head, 1);
//
//        System.out.println(reverseLinkedList.isPalindrome(head));

        /*

         **************** Odd Even Linked List ****************

         */

//        head = list.insertAtNthPos(head, 1, 0);
//        head = list.insertAtTail(head, 2);
//        head = list.insertAtTail(head, 3);
//        head = list.insertAtTail(head, 4);
//        head = list.insertAtTail(head, 5);
////        head = list.insertAtTail(head, 6);
////        head = list.insertAtTail(head, 7);
//        head = list.insertAtTail(head, 8);
//
//        head = moreOnLinkedLists.oddEvenList(head);
//
//        list.displayLL(head);


        /*

         **************** Remove Zero Sum Consecutive Nodes from Linked List ****************

         */

//        head = list.insertAtNthPos(head, 1 , 0);
//        head = list.insertAtTail(head, 2);
//        head = list.insertAtTail(head, -3);
//        head = list.insertAtTail(head, 3);
//        head = list.insertAtTail(head, -2);
//
//        head = MoreOnLinkedLists.removeZeroSumSublists(head);
//
//        list.displayLL(head);

        /*

         **************** Merge In Between Linked Lists ****************

         */

//        ListNode list1 = new ListNode();
//
//        ListNode head1 = null;
//
//        head1 = list1.insertAtNthPos(null, 10, 0);
//        head1 = list1.insertAtTail(head1, 1);
//        head1 = list1.insertAtTail(head1, 13);
//        head1 = list1.insertAtTail(head1, 6);
//        head1 = list1.insertAtTail(head1, 9);
//        head1 = list1.insertAtTail(head1, 5);
//
//        head1.displayLL(head1);
//
//        ListNode list2 = new ListNode();
//        ListNode head2 = null;
//
//
//        head2 = list2.insertAtNthPos(null, 1000000, 0);
//        head2 = list2.insertAtTail(head2, 1000001);
//        head2 = list2.insertAtTail(head2, 1000002);
//
//
//        head2.displayLL(head2);
//
//        head1 = moreOnLinkedLists.mergeInBetween(head1, 3, 4, head2);
//        head1.displayLL(head1);


//       head1.displayLL(head1);

        /*

         **************** Merge k sorted lists ****************

         */

//        ListNode list1 = new ListNode();
//
//        ListNode head1 = null;
//
//        head1 = list1.insertAtNthPos(null, 1, 0);
//        head1 = list1.insertAtTail(head1, 4);
//        head1 = list1.insertAtTail(head1, 5);
//
//        ListNode list2 = new ListNode();
//
//        ListNode head2 = null;
//
//        head2 = list2.insertAtNthPos(null, 1, 0);
//        head2 = list2.insertAtTail(head2, 3);
//        head2 = list2.insertAtTail(head2, 4);
//
//        ListNode list3 = new ListNode();
//
//        ListNode head3 = null;
//
//        head3 = list3.insertAtNthPos(null, 2, 0);
//        head3 = list3.insertAtTail(head3, 6);
//
//        ListNode[] listNodes = {head1, head2, head3};
//
//        list1.displayLL(head1);
//        list2.displayLL(head2);
//        list3.displayLL(head3);
//
////        System.out.println(Arrays.toString(listNodes));
//
//        ListNode listFinal = new ListNode();
//
//        ListNode headFinal = null;
//
////        headFinal = listFinal.insertAtNthPos(null, Integer.MAX_VALUE, 0);
//
////        headFinal.displayLL(headFinal);
//
//
//        headFinal = mergeTwoSortedLists.mergeKLists(listNodes);
////
////        headFinal = listFinal.deleteAtHead(headFinal);
////
//        headFinal.displayLL(headFinal);

        /*

         **************** Reverse nodes in k-group ****************

         */


        ListNode list1 = new ListNode();

        ListNode head1 = null;

        head1 = list1.insertAtNthPos(null, 1, 0);
        head1 = list1.insertAtTail(head1, 2);
        head1 = list1.insertAtTail(head1, 3);
        head1 = list1.insertAtTail(head1, 4);
        head1 = list1.insertAtTail(head1, 5);

        head1.displayLL(head1);

        head1 = reverseLinkedList.reverseKGroup(head1, 2);

        head1.displayLL(head1);

    }
}
