package com.deepanshu.dsa.stacks;

public class NGindex <K,V> {
    private K key;
    private V value;

    public NGindex(K key,V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
