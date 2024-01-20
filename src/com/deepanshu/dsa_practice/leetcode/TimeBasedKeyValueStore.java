package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Pair <K,V> {
    private K timestamp;
    private V value;

    public Pair(K timestamp,V value) {
        this.timestamp= timestamp;
        this.value = value;
    }

    public K getKey() {
        return timestamp;
    }

    public V getValue() {
        return value;
    }
}

public class TimeBasedKeyValueStore {

    HashMap<String, List<Pair<String, Integer>>> map;
    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair<String, Integer>> list = map.get(key);
        return search(list, timestamp);
    }

    public String search(List<Pair<String, Integer>> list, int timestamp) {
        int low = 0;
        int high = list.size() - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (list.get(mid).getValue() <= timestamp) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return list.get(low).getValue() <= timestamp ? list.get(low).getKey() : "";
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();
//        obj.set("foo", "bar", 1);
//        System.out.println(obj.get("foo", 1));
//        System.out.println(obj.get("foo", 3));
//        obj.set("foo", "bar2", 4);
//        System.out.println(obj.get("foo", 4));
//        System.out.println(obj.get("foo", 5));

        obj.set("love","high",10);
        obj.set("love","low",20);
        System.out.println(obj.get("love",5));
        System.out.println(obj.get("love",10));
        System.out.println(obj.get("love",15));
        System.out.println(obj.get("love",20));
        System.out.println(obj.get("love",25));
    }
}
