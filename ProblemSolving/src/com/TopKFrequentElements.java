package com;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> s = new HashMap();
		for (int i = 0; i < nums.length; ++i) {
			if (s.containsKey(nums[i])) {
				s.put(nums[i], s.get(nums[i]) + 1);
			} else {
				s.put(nums[i], 0);
			}
		}
		// This will use the value to order
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> s.get(a) - s.get(b));
		// adds the key to map
		queue.addAll(s.keySet());
		int[] out = new int[k];
		for (int i = 0; i < k; ++i) {
			out[i] = queue.remove();
		}
		return out;
	}
}
