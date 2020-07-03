package com;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
		// We use comparator to convert min heap to max heap
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for (int i = 0; i < nums.length; ++i) {
			queue.add(nums[i]);
		}
		int temp = 0;
		while (k > 0) {
			temp = queue.remove();
			k--;
		}
		return temp;
	}
}
