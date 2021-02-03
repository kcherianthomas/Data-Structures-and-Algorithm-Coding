package com;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] out = new int[nums.length - k + 1];
		Deque<Integer> q = new LinkedList<>();
		for (int i = 0; i < nums.length; ++i) {
			// if front value in queue less than i-k+1 remove that value
			if (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// check if i value greater than front value if so then remove all elements from
			// q and insert current value
			while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
				q.pollLast();
			}
			q.add(i);
			// out[i-k+1] = frontvalue
			if (i - k + 1 >= 0) {
				out[i - k + 1] = nums[q.peekFirst()];
			}

		}
		return out;
	}
}

// 0 1 2 3 length = 4
// 
//k =2 