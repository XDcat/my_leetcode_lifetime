package com.zlj.os;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
    static class Entry<K, V>{
        public K key;
        public V value;
        public Entry<K, V> pre;
        public Entry<K, V> next;
        public Entry(){

        }
        public Entry(K k, V v){
            this.key = k;
            this.value = v;
        }
    }

    // attr
    private Map<K, Entry<K, V>> cache;
    private int size, capacity;
    private Entry<K, V> head, tail;

    // constructor
    public LRU(int capacity){
        cache = new HashMap<>();
        head = new Entry<>();
        tail = new Entry<>();
        this.capacity = capacity;
    }

    public V get(K key){
        Entry<K, V> entry = cache.get(key);

        if (entry != null){
            moveToHead(entry);
            return entry.value;
        }

        return null;
    }

    public void put(K key, V value){
        Entry<K, V> entry = this.cache.get(key);
        if (entry == null){
            entry = new Entry<>(key, value);
            cache.put(key, entry);
            addToHead(entry);
            size ++;
            if (size > capacity){
                Entry<K, V> tail = removeTail();
                cache.remove(tail.key);
                size --;
            }
        } else {
            entry.value = value;
            moveToHead(entry);
        }
    }

    private void moveToHead(Entry<K, V> entry){
        removeNode(entry);
        addToHead(entry);
    }
    private void addToHead(Entry<K, V> entry){
        entry.next = this.head.next;
        entry.pre = this.head;

        entry.next.pre = entry;
        entry.pre.next = entry;
    }

    private void removeNode(Entry<K, V> entry){
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
    }

    private Entry<K, V> removeTail(){
        Entry<K, V> tail = this.tail.pre;
        removeNode(tail);
        return tail;
    }
}
