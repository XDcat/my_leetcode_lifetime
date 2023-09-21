package com.zlj.test.t1;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-08-10
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
            }
        };

        thread.start();

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(null));
        System.out.println(map.get(1));
        NavigableMap<Integer, Integer> treeMap = new TreeMap<>();
    }
}
