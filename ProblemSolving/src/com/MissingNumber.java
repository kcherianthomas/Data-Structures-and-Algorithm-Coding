package com;

public class MissingNumber {
	/*
	 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
	 * find the one that is missing from the array.
	 */
	public int missingNumber(int[] nums) {
		int[] arr = new int[nums.length + 1];
		// setting all values of arr as 0
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = 0;
		}
		// storing each number at its index
		for (int i = 0; i < nums.length; ++i) {
			arr[nums[i]] = 1;
		}
		for (int i = 0; i < nums.length; ++i) {
			if (arr[i] == 0) {
				return i;
			}
		}
		return 0;
	}
}
