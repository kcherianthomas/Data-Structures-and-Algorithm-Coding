package com;

/*
 * Given an array nums, write a function to move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.
 * The code should be in-place without making a copy of the array
 */
public class MoveZeroes {
	/*
	 * The time complexity is O(nums.length)
	 */
	public void moveZeroes(int[] nums) {
		int size = nums.length;
		int lastNonZero=0;
		for(int i=0;i<size;++i) {
			if(nums[i]!=0) {
				nums[lastNonZero]=nums[i];
				lastNonZero++;
			}
		}
		for(int i=lastNonZero;i<size;++i) {
			nums[i]=0;
		}
	}
}

