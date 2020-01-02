package com;

import java.util.HashSet;
import java.util.Set;
/*
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
	/*
	 * Using as set to check for duplicate
	 * The time complexity is O(nums.length)
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (Integer temp : nums) {
			if (set.contains(temp)) {
				return true;
			} else {
				set.add(temp);
			}
		}
		return false;
	}
}
