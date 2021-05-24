package com;

public class MaxConsecutiveOnesII {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int start = 0;
		int first = -1;
		
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 0 && first == -1) {
				first = i;
			} else if (nums[i] == 0) {
				max = Math.max(max, i - start);
				start = first + 1;
				first = i;
			}
		}
		
		max = Math.max(max, nums.length - start);
		return max;
	}
}
