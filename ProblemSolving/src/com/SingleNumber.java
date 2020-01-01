package com;

/*
 * Given a non-empty array of integers, every element appears twice except for one. 
 * Find that single one. 
 */
public class SingleNumber {
	/*
	 * My code uses a xor function which helps 
	 * to eliminate duplicates and maintain a
	 * time complexity of O(n)
	 */
	public int singleNumber(int[] nums) {
		int val = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			val ^= nums[i];
		}
		return val;
	}
}
