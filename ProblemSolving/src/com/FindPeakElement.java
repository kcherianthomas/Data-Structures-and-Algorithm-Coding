package com;

/*
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], 
 * find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index
 * to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {

		int n = nums.length;
		// base case
		if (n == 1) {
			return 0;
		}
		int left = 0;
		int right = n - 1;
		int mid = (left + (right - left) / 2);
		while (mid < n && mid >= 0) {

			// I am handling end cases in first two if
			if (mid == 0 && (nums[mid] > nums[mid + 1])) {
				return mid;
			} else if ((n - 1) == mid && (nums[mid] > nums[mid - 1])) {
				return mid;
			} else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
				return mid;
			} else if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
				mid = (left + (right - left) / 2);
			} else {
				right = mid - 1;
				mid = (left + (right - left) / 2);
			}
		}
		return 0;
	}
}
