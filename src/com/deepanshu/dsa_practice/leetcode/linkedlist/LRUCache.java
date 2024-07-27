package com.deepanshu.dsa_practice.leetcode.linkedlist;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
//    private LinkedHashMap<Integer, Integer> map;
//    private final int CAPACITY;
//
//    public LRUCache(int capacity) {
//        CAPACITY = capacity;
//        map = new LinkedHashMap<>(capacity, 0.75f, true) {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry eldest) {
//                return size() > CAPACITY;
//            }
//        };
//    }
//
//    public int get(int key) {
//        return map.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        map.put(key, value);
//    }

    private static class ListNode {
        int key;
        int value;

        ListNode next;
        ListNode prev;

        ListNode() {}

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        ListNode(int key, int value, ListNode next, ListNode prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public ListNode[] map;
    public int count, capacity;
    public ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;

        map = new ListNode[10_000 + 1];

        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);

        head.next = tail;
        tail.prev = head;

        head.prev = null;
        tail.next = null;
    }

    public void deleteNode(ListNode listNode) {
        listNode.prev.next = listNode.next;
        listNode.next.prev = listNode.prev;

        return;
    }

    public void addToHead(ListNode listNode) {
        listNode.next = head.next;
        listNode.next.prev = listNode;
        listNode.prev = head;

        head.next = listNode;

        return;
    }

    public int get(int key) {
        if (map[key] != null) {

            ListNode listNode = map[key];

            int listNodeVal = listNode.value;

            deleteNode(listNode);

            addToHead(listNode);

            return listNodeVal;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map[key] != null) {
            ListNode listNode = map[key];

            listNode.value = value;

            deleteNode(listNode);

            addToHead(listNode);
        } else {
            ListNode listNode = new ListNode(key, value);

            map[key] = listNode;

            if (count < capacity) {
                count++;
                addToHead(listNode);
            } else {
                map[tail.prev.key] = null;

                deleteNode(tail.prev);

                addToHead(listNode);
            }
        }

        return;
    }
}
