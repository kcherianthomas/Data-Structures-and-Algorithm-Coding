package com;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int out = 1;
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			dp[i] = 1;
		}
		for (int i = 1; i < nums.length; ++i) {
			for (int j = 0; j <= i; ++j) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
				out = Math.max(out, dp[i]);
			}
		}
		return out;
	}
}
