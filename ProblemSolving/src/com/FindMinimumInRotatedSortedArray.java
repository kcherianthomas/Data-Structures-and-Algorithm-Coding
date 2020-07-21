package com;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		// we are going to consider that one half is sorted every time we divide into
		// two half and we keep taking min in sorted half compare with min which we get
		// again by dividing assorted half
		int left = 0;
		int right = nums.length - 1;
		
		int min = Integer.MAX_VALUE;
		while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[left]) {
				min = Math.min(nums[left], min);
				left = mid + 1;
			} else {
				min = Math.min(nums[mid], min);
				right = mid - 1;
			}

		}
		return min;
	}
}
