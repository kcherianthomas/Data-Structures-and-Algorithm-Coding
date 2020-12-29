package com;

public class MinimumMovestoEqualArrayElements {
	/*
	 * Incrementing n-1 elements is equal to decrementing 1 element
	 */
	public int minMoves(int[] nums) {
		if (nums.length <= 1) {
			return 0;
		}
		int min = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			min = Math.min(min, nums[i]);
		}
		int count = 0;
		for (int i = 0; i < nums.length; ++i) {
			count += (nums[i] - min);
		}
		return count;
	}
}
