package com;

public class SortColors {
	public void sortColors(int[] nums) {
		int low = 0;
		int medium = 0;
		int high = nums.length - 1;

		while (medium <=high) {
			if (nums[medium] == 0) {
				int temp = nums[low];
				nums[low] = nums[medium];
				nums[medium] = temp;
				low++;
				medium++;
				
			} else if (nums[medium] == 1) {
				medium++;
				
			} else if (nums[medium] == 2) {
				int temp = nums[high];
				nums[high] = nums[medium];
				nums[medium] = temp;
				high--;

			}
		}
	}
}
