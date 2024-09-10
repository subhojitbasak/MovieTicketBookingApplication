package com.github.subhojitbasak.MovieTicketBookingApplication.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class MRUCache <K, V> extends LinkedHashMap<K, V> {
        private final int maxSize;

        public MRUCache(int maxSize) {
            super(maxSize, 0.75f, true);
            this.maxSize = maxSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            // MRU: remove the most recently used item (reversed LRU logic)
            return size() > maxSize;
        }
    }


