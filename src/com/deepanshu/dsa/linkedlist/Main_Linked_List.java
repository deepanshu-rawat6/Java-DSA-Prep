package com.deepanshu.dsa.linkedlist;

import org.w3c.dom.ls.DOMImplementationLS;

public class Main_Linked_List {
    public static void main(String[] args) {
        LL list = new LL();
//        insertion value in the beginning of the list
        list.insertFirst(3);
        list.insertFirst(5);
        list.insertFirst(9);
        list.insertFirst(8);
//        displaying the list
        list.display();
//        inserting value at the last place of the list
        list.insertLast(99);
//        displaying the list, after insertion at last index
        list.display();
//        inserting the list element at the 3rd index
        list.insert(100,3);
//        displaying the list, after adding value at 3rd position
        list.display();
//        deleting the first value of the list
        System.out.println(list.deleteFirst());
//        displaying the list after deletion at 1st position
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();

//        System.out.println("\nDoubly Linked List operations:\n");
//        DLL Dlist = new DLL();
//        Dlist.insertFirst(3);
//        Dlist.insertFirst(2);
//        Dlist.insertFirst(8);
//        Dlist.insertFirst(17);
//
////        Dlist.display();
////        adding element to the end of DLl
//        Dlist.insertLast(99);
////        Dlist.display();
//
//        Dlist.insert(8,65);
//        Dlist.display();
//
//
//        CLL Clist = new CLL();
//        Clist.insert(23);
//        Clist.insert(3);
//        Clist.insert(19);
//        Clist.insert(75);
//        Clist.display();
//        Clist.delete(19);
//        Clist.display();

        list.insertRecursion(1000,2);
        list.display();
    }
}
