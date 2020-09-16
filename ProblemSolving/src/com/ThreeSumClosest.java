package com;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		/*
		 * we are going to get minimum difference between target and a+b+c Suppose if
		 * target = 3 and we have a+b+c = 1 and 4 we know we need 4 So, we are going to
		 * use abs value of target-(a+b+c) and comapre with abs value of
		 * currentdifference
		 */
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; ++i) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int aPlusBPlusC = nums[i] + nums[left] + nums[right];

				if (Math.abs(target - aPlusBPlusC) < Math.abs(diff)) {
					diff = target - aPlusBPlusC;
				}

				if (aPlusBPlusC == target) {
					return target;
				} else if (aPlusBPlusC > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return target - diff;
	}
}
