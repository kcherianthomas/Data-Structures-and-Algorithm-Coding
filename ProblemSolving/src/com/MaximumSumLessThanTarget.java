package com;

import java.util.Arrays;

public class MaximumSumLessThanTarget {
	public int maximumSumLessThanTarget(int[] candidates, int target) {
		Arrays.sort(candidates);
		int max = 0;
		max = maximumSum(candidates, target, target, 0, max);
		System.out.println(max);
		return max;

	}

	private int maximumSum(int[] candidates, int target, int totalTarget, int index, int max) {
		if (target >= 0) {
			max = Math.max(max, totalTarget - target);
		}
		if (target < 0) {
			return max;
		}
		for (int i = index; i < candidates.length; ++i) {
			max = maximumSum(candidates, target - candidates[i], totalTarget, i + 1, max);
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSumLessThanTarget a = new MaximumSumLessThanTarget();
		a.maximumSumLessThanTarget(new int[] { 4, 8, 5, 9 }, 20);
	}

}
