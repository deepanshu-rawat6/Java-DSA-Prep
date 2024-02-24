package com.deepanshu.dsa_practice.leetcode.linkedlist;

public class Main_Linked_List {

    public static ListNode head = null;

    public static void main(String[] args) {
        ListNode list = new ListNode();
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        CycleProblemsInLinkedList cycleProblemsInLinkedList = new CycleProblemsInLinkedList();
        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

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
//        ListNode head3 = null;
//        head3 = list2.insertAtNthPos(null, 1, 0);
//        head3 = list2.insertAtTail(head3, 3);
//        head3 = list2.insertAtTail(head3, 4);
//        head3.displayLL(head3);
//
//        head = mergeTwoSortedLists.mergeTwoLists(head2, head3);
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
//        cycleLinkedList.addCycle(head, 2);
//
//        System.out.println("\nDoes the linked list have a cycle: " + cycleLinkedList.hasCycle(head));

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
//        head = removeNthNodeFromEndofList.removeNthFromEnd(head,1);
//        list.displayLL(head);

        /*

         **************** Add Two Numbers ****************

         */

        ListNode list1 = new ListNode();

        ListNode head2 = null;

        head2 = list1.insertAtNthPos(null, 2, 0);
        head2 = list1.insertAtTail(head2, 4);
        head2 = list1.insertAtTail(head2, 9);

//        head2 = list1.insertAtNthPos(null, 9, 0);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);
//        head2 = list1.insertAtTail(head2, 9);

        head2.displayLL(head2);

        ListNode list2 = new ListNode();
        ListNode head3 = null;

        head3 = list2.insertAtNthPos(null, 5, 0);
        head3 = list2.insertAtTail(head3, 6);
        head3 = list2.insertAtTail(head3, 4);
        head3 = list2.insertAtTail(head3, 9);

//        head3 = list2.insertAtNthPos(null, 9, 0);
//        head3 = list2.insertAtTail(head3, 9);
//        head3 = list2.insertAtTail(head3, 9);
//        head3 = list2.insertAtTail(head3, 9);

        head3.displayLL(head3);

       head = addTwoNumbers.addTwoNumbers(head2, head3);
       head.displayLL(head);
    }
}
