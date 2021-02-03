package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> count = new HashMap<>();
		for (String word : words) {
			if (count.containsKey(word)) {
				count.put(word, count.get(word) + 1);
			} else {
				count.put(word, 1);
			}
		}
		PriorityQueue<String> q = new PriorityQueue<>((a, b) -> {
			if (count.get(a) != count.get(b)) {
				return count.get(b) - (count.get(a));
			} else {
				return a.compareTo(b);
			}
		});
		q.addAll(count.keySet());
		List<String> out = new ArrayList<>();
		for (int i = 0; i < k; ++i) {
			out.add(q.remove());
		}
		return out;
	}
}
