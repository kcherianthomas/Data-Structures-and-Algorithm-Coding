package com;

public class FirstMissingPositive {
	/*
	 * The approach is such that the algorithm uses o(n) time and constant space
	 * complexity
	 */
	public int firstMissingPositive(int[] nums) {
		if (nums.length == 0) {
			return 1;
		}
		// negative number, numbers greater than nums.length are set to zero
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] <= 0 || nums[i] > nums.length) {
				nums[i] = 0;
			}
		}

		// zeroes are moved to last
		int nonNum = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 0) {
				nums[nonNum++] = nums[i];
			}
		}
		for (int i = nonNum; i < nums.length; ++i) {
			nums[i] = 0;
		}
		// If we have a non zero number, then the index at non zero number -1 is changed to zero
		for (int i = 0; i < nums.length; ++i) {
			if (Math.abs(nums[i]) > 0 && nums[Math.abs(nums[i]) - 1] > 0) {
				nums[Math.abs(nums[i]) - 1] *= -1;
			}
		}
		int i = 0;
		for (i = 0; i < nums.length; ++i) {
			if (nums[i] >= 0) {
				return i + 1;
			}
		}
		return i + 1;
	}
}
