package com;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {
				return mid;
				/*
				 * we take the fact that one of half of rotated sorted array will still be like
				 * a normal sorted array. For eg : 6 8 9 0 1 2 3 4 5 here mid is 1 the right half
				 * is sorted 1 2 3 4 5
				 */
			} else if (nums[mid] >= nums[left]) {
				if (target >= nums[left] && target <= nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[right] > nums[mid]) {
				if (target > nums[mid] && target <= nums[right]) {

					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;

	}
}
