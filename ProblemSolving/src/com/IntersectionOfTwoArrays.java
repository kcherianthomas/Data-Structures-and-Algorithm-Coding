package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//Given two arrays, write a function to compute their intersection.
public class IntersectionOfTwoArrays {
	/* Although the time complexity of the logic written is O(n), the overhead is very high,
	 * It might be easier to use a sorting logic with time complexity O(nlogn) if the no of
	 * numbers are small
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		if (null == nums1 || null == nums2 || nums1.length == 0 || nums2.length == 0) {
			return new int[] {};
		}
		Map<Integer, Integer> num1Map = new HashMap<>();
		Map<Integer, Integer> num2Map = new HashMap<>();
		//Making a nums1 array frequency map
		for (int i = 0; i < nums1.length; ++i) {
			if (num1Map.containsKey(nums1[i])) {
				num1Map.put(nums1[i], num1Map.get(nums1[i]) + 1);
			} else {
				num1Map.put(nums1[i], 1);
			}
		}
		//Making a nums2 array frequency map
		for (int i = 0; i < nums2.length; ++i) {
			if (num2Map.containsKey(nums2[i])) {
				num2Map.put(nums2[i], num2Map.get(nums2[i]) + 1);
			} else {
				num2Map.put(nums2[i], 1);
			}
		}
		/* Adding to an arraylist if it appears in both maps
		 * The value is added to arraylist as min of count frequency
		 */
		ArrayList<Integer> intersectList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : num1Map.entrySet()) {
			if (entry.getValue() >= 1 && num2Map.containsKey(entry.getKey())) {
				int min = Math.min(entry.getValue(), num2Map.get(entry.getKey()));
				while (min != 0) {
					intersectList.add(entry.getKey());
					--min;
				}
			}
		}
		//Transforming the List to int array
		int [] intersectArray = new int[intersectList.size() ];
		int i=0;
		for(Integer temp :intersectList ) {
			intersectArray[i] = temp;
			++i;
		}
		return intersectArray;
	}
}
