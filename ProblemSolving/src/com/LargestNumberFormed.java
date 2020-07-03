package com;

import java.util.Arrays;
import java.util.Comparator;

//Given a list of non negative integers, arrange them such that they form the largest number.
public class LargestNumberFormed {
	public String largestNumber(int[] nums) {
		String[] str = new String[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			str[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(str, new CustomComparatorForSorting());
		if (Integer.parseInt(str[0]) == 0) {
			return "0";
		} else {
			StringBuilder out = new StringBuilder();
			for (int i = 0; i < nums.length; ++i) {
				out.append(str[i]);
			}
			return out.toString();
		}
	}

	private class CustomComparatorForSorting implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return (o2 + o1).compareTo(o1 + o2);
		}
	}
}
