package com.deepanshu.linkedlist;

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
    }
}
