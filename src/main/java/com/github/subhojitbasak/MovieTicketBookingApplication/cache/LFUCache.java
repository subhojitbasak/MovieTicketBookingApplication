package com.github.subhojitbasak.MovieTicketBookingApplication.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LFUCache <K, V> {
    private final int capacity;
    private Map<K, V> cache;
    private Map<K, Integer> usageCount;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.usageCount = new HashMap<>();
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            usageCount.put(key, usageCount.getOrDefault(key, 0) + 1);
            return cache.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            K lfuKey = getLFUKey();
            cache.remove(lfuKey);
            usageCount.remove(lfuKey);
        }
        cache.put(key, value);
        usageCount.put(key, 1);
    }

    private K getLFUKey() {
        return Collections.min(usageCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
