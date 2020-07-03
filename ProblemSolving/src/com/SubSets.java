package com;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();
		if (nums == null) {
			return output;
		} else {
			output.add(new ArrayList<>());
			for (int i = 1; i <= nums.length; ++i) {
				findsubsets(nums, output, new ArrayList<>(), i, 0);
			}
		}
		return output;
	}

	private void findsubsets(int[] nums, List<List<Integer>> output, List<Integer> cur, int subsetSize, int index) {
		if (cur.size() == subsetSize) {
			output.add(new ArrayList(cur));
		}
		for (int i = index; i < nums.length; ++i) {
			cur.add(nums[i]);
			findsubsets(nums, output, cur, subsetSize, i + 1);
			cur.remove(cur.size() - 1);
		}

	}
}
