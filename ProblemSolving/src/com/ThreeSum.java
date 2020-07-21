package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given an array nums of n integers, are there elements a, b, c in nums 
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> out = new ArrayList<>();
		Set<List<Integer>> duplicate = new HashSet<>();
		if (nums.length < 3) {
			return out;
		}
		Arrays.sort(nums);
		for (int current = 0; current < nums.length - 2; ++current) {
			if (current > 0 && nums[current] == nums[current - 1]) {
				continue;
			}
			int left = current + 1;
			int right = nums.length - 1;

			while (left < right) {

				int target = nums[current] + nums[left] + nums[right];
				if (target == 0) {

					List<Integer> list = new ArrayList<>();
					list.add(nums[current]);
					list.add(nums[left]);
					list.add(nums[right]);
					if (!duplicate.contains(list)) {
						duplicate.add(list);
						out.add(list);
					}
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					left++;
					right--;
				} else if (target > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return out;

	}
}
