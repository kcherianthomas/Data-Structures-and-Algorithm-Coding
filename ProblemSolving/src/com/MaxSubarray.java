package com;

/* Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 */
public class MaxSubarray {
	public int maxSubArray(int[] nums) {
		// Base case
		if (null == nums || nums.length == 0) {
			return 0;
		}
		// We assign currMax and maximumSoFar as first element in the array.
		int maxSoFar = nums[0];
		int currMax = nums[0];

		for (int i = 1; i < nums.length; ++i) {
			/* At any index i the currmax will be the val of i or sum of prev 
			 * subarray + val at i
			 */
			currMax = Math.max(currMax + nums[i], nums[i]);
			// We check if the currMax becomes greater than maxSoFar
			maxSoFar = Math.max(currMax, maxSoFar);
		}
		return maxSoFar;
	}
	
}
