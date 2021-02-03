package com;


import java.util.HashMap;

public class KdiffPairsInAnArray {
	public int findPairs(int[] nums, int k) {
		int unique = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		// 5,4,2,1 k=1
		for (Integer val : map.keySet()) {
			int numsi = val;
			int numsj = val - k;
			if (numsj > numsi) {
				continue;
			}
			if (numsi == numsj) {
				if (map.get(val) == 1) {
					continue;
				}
			}
			if (map.containsKey(numsj)) {
				unique++;
			}
		}
		return unique;
	}
}
