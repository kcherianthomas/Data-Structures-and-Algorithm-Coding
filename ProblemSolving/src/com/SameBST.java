package com;

import java.util.ArrayList;
import java.util.List;

public class SameBST {
	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		if ((arrayOne == null && arrayTwo == null)) {
			return true;
		} else if (arrayOne == null || arrayTwo == null) {
			return false;
		} else if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
			return true;
		}
		if (arrayOne.size() != arrayTwo.size()) {
			return false;
		}
		if (arrayOne.get(0) != arrayTwo.get(0)) {
			return false;
		}
		return sameBsts(findMinValues(arrayOne), findMinValues(arrayTwo))
				&& sameBsts(findMaxValues(arrayOne), findMaxValues(arrayTwo));
	}

	private static List<Integer> findMinValues(List<Integer> array) {
		List<Integer> min = new ArrayList<>();
		for (int i = 1; i < array.size(); ++i) {
			if (array.get(i) < array.get(0)) {
				min.add(array.get(i));
			}
		}
		return min;
	}

	private static List<Integer> findMaxValues(List<Integer> array) {
		List<Integer> max = new ArrayList<>();
		for (int i = 1; i < array.size(); ++i) {
			if (array.get(i) >= array.get(0)) {
				max.add(array.get(i));
			}
		}
		return max;
	}

}
