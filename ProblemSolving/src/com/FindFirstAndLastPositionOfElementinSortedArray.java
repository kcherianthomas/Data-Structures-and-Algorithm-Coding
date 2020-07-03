package com;

public class FindFirstAndLastPositionOfElementinSortedArray {
	public int[] searchRange(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (high >= low) {
			int mid = (high + low) >> 1;
			if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				return new int[] { getLowerBound(nums, target, low, high), getHigherBound(nums, target, low, high) };
			}
		}
		return new int[] { -1, -1 };
	}

	private int getHigherBound(int[] nums, int target, int low, int high) {
		int targetIndex = (high + low) >> 1;
		while (high >= low) {
			int mid = (high + low) >> 1;
			if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				targetIndex = mid;
				low = mid + 1;
			}
		}
		return targetIndex;
	}

	private int getLowerBound(int[] nums, int target, int low, int high) {
		int targetIndex = (high + low) >> 2;
		while (high >= low) {
			int mid = (high + low) >> 2;
			if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				targetIndex = mid;
				high = mid - 1;
			}
		}
		return targetIndex;
	}
}
