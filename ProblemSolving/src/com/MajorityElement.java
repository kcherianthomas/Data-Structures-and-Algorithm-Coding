package com;
/*
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * Assume a non empty array always and majority element always exist
 */
public class MajorityElement {
	/*
	 * My code uses Boyer-Moore Voting Algorithm. The time complexity is 0(nums.length)
	 * The code works only if we have a majority element.
	 * Using hashing can also give us code with same time complexity
	 */
	public int majorityElement(int[] nums) {
		int count = 1;
		int index = 0;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == nums[index]) {
				count++;
				index = i;
			} else if (count == 0) {
				index = i;
				count = 1;
			} else {
				count--;
			}
		}
		return nums[index];
	}
}
