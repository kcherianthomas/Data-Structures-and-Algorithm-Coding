package com;

public class TargetSum {
	/*
	 * This takes 2^n time complexity
	 */
	public int findTargetSumWays(int[] nums, int S) {
		findTargetSum(nums, 0, S, 0);
		return count;
	}

	int count = 0;

	public void findTargetSum(int[] nums, int index, int S, int currentSum) {
		if (index == nums.length) {
			if (currentSum == S) {
				count++;
			}
			return;
		} else {
			findTargetSum(nums, index + 1, S, currentSum + nums[index]);
			findTargetSum(nums, index + 1, S, currentSum - nums[index]);
		}
	}
}
