package com;

public class PartitionArrayforMaximumSum {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int[] dp = new int[arr.length];
		// let dp[i] be max sum at i
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < k; ++i) {
			max = Math.max(max, arr[i]);
			dp[i] = max * (i + 1);
		}

		for (int i = k; i < arr.length; ++i) {
			max = arr[i];
			for (int j = 1; j <= k; ++j) {
				max = Math.max(max, arr[i - j + 1]);
				dp[i] = Math.max(dp[i], dp[i - j] + max * (j));
			}
		}

		return dp[arr.length - 1];
	}

}
