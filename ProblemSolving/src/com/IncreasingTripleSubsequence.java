package com;

public class IncreasingTripleSubsequence {
	public boolean increasingTriplet(int[] nums) {
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; ++i) {
			int temp = nums[i];
			if (firstMin >= temp) {
				firstMin = temp;
			} else if (secondMin >= temp) {
				secondMin = temp;
			} else if (secondMin < temp) {
				return true;
			}
		}
		return false;
	}
}
