package com;

public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean unsortedArrayStart = false;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] < nums[i - 1]) {
				unsortedArrayStart = true;
			}
			if (unsortedArrayStart) {
				min = Math.min(min, nums[i]);
			}
		}
		unsortedArrayStart = true;
		for (int i = nums.length - 2; i >= 0; --i) {
			if (nums[i] > nums[i + 1]) {
				unsortedArrayStart = true;
			}
			if (unsortedArrayStart) {
				max = Math.max(max, nums[i]);
			}
		}
		int start;
		int end;
		for (start = 0; start < nums.length; ++start) {
			if (nums[start] < min) {
				break;
			}
		}
		for (end = nums.length; end > 0; --end) {
			if (nums[end] < max) {
				break;
			}
		}
		return end - start + 1;

	}
}
