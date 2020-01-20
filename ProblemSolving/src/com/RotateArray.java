package com;

//We have to rotate the elements of the given array k times to the right.
public class RotateArray {
	/* Here I have used an approach where we use extra space. 
	 * The time complexity is O(nums.length)
	 */
	public void rotate(int[] nums, int k) {
		int[] newNums = new int[nums.length];

		int j = 0;
		for (int i = 0; i < nums.length; ++i) {
			newNums[(i + k) % nums.length] = nums[j++];
		}

		for (int i = 0; i < nums.length; ++i) {
			nums[i] = newNums[i];
		}

	}
}
