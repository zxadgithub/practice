package com.zxa.practice.leetcode.evict;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author zhangxinan
 * @Classname LRUCache
 * @Date 2021/3/15 9:09 下午
 */
public class LRUCache  extends LinkedHashMap<Integer, Integer> {
        int size = 0;
        public LRUCache(int capacity) {
            super(capacity,0.75F, true);
            size = capacity;
        }

        public int get(int key) {
           return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
           super.put(key, value);
        }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > size;
    }
}
