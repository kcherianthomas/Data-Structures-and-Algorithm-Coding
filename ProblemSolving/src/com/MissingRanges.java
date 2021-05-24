package com;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		// 1 2 4 5 9
		List<String> out = new ArrayList<>();
		if (nums.length == 0) {
			if (lower == upper) {
				out.add(String.valueOf(lower));
			} else {
				out.add(lower + "->" + upper);
			}
			return out;
		}
		if (nums[0] - lower == 1) {
			out.add(String.valueOf(lower));
		} else if (nums[0] - lower > 1) {
			out.add(lower + "->" + (nums[0] - 1));
		}
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i + 1] - nums[i] == 2) {
				out.add(String.valueOf(nums[i] + 1));
			} else if (nums[i + 1] - nums[i] > 2) {
				out.add((nums[i] + 1) + "->" + (nums[i + 1] - 1));
			}
		}
		if (upper - nums[nums.length - 1] == 1) {
			out.add(String.valueOf(upper));
		} else if (upper - nums[nums.length - 1] > 1) {
			out.add((nums[nums.length - 1] + 1) + "->" + upper);
		}
		return out;
	}
}
