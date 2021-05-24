package com;

import java.util.LinkedHashMap;

public class LRUCacheUsingLinkedHashMap {
	class LRUCache {

		LinkedHashMap<Integer, Integer> cache = null;
		int maxCapacity = 0;

		public LRUCache(int capacity) {
			cache = new LinkedHashMap<>();
			maxCapacity = capacity;
		}

		public int get(int key) {
			if (cache.containsKey(key)) {
				int val = cache.get(key);
				cache.remove(key);
				cache.put(key, val);
				return val;
			} else {
				return -1;
			}
		}

		public void put(int key, int value) {
			if (cache.size() == maxCapacity) {
				if (!cache.containsKey(key)) {
					cache.remove(getFirstKey());
					cache.put(key, value);
				} else {
					cache.remove(key);
					cache.put(key, value);
				}
			} else {
				if (cache.containsKey(key)) {
					cache.remove(key);
				}
				cache.put(key, value);
			}
		}

		private int getFirstKey() {
			if (this.cache.size() == 0) {
				return -1;
			}
			int firstKey = -1;
			for (int key : this.cache.keySet()) {
				firstKey = key;
				break;
			}
			return firstKey;
		}
	}
}
