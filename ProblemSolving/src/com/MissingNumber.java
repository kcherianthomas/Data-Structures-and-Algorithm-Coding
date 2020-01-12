package com;
/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 */
public class MissingNumber {
	/*
	 * Using that property of xor. xor with 0 to N will remove all duplicates
	 * except the missing value
	 */
	public int missingNumber(int[] nums) {
		int val=0;
		int i=0;
		//we are xoring
		for(i=0;i<nums.length;++i) {
			val=val^i^nums[i];
		}
		//the below step is because it is 0 to N and not 1 to N
		val = val^i;
		return val;
	}
}
