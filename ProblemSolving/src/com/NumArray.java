package com;

public class NumArray {
	int[] sums = null;

	public NumArray(int[] nums) {
		this.sums = new int[nums.length];
		if (nums.length > 0) {
			this.sums[0] = nums[0];
		}
		for (int i = 1; i < sums.length; ++i) {
			this.sums[i] = nums[i] + this.sums[i - 1];
			System.out.println("sum" + i + "" + this.sums[i]);
		}
	}

	public int sumRange(int i, int j) {

		return i > 0 ? (sums[j] - sums[i - 1]) : sums[j];
	}
}
