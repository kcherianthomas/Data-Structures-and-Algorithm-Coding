package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * Given an array of integers arr, write a function that returns
 * true if and only if the number of occurrences of each value in the array is unique.
 */
public class UniqueNoOfOccurences {
	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; ++i) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		Set<Integer> a = new HashSet<>();
		for (Integer temp : map.values()) {
			if (a.contains(temp)) {
				return false;
			} else {
				a.add(temp);
			}
		}
		return true;
	}
}