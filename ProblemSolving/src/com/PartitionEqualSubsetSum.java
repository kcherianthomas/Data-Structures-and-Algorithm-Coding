package com;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
		}
		if (sum % 2 == 1) {
			return false;
		}
		int[][] dp = new int[nums.length + 1][(sum / 2) + 1];
		for (int i = 1; i < dp.length; i++) {
			int value = nums[i - 1];
			for (int curSum = 1; curSum < dp[0].length; ++curSum) {
				if (curSum >= value) {
					dp[i][curSum] = Math.max(dp[i - 1][curSum], value + dp[i - 1][curSum - value]);
				} else {
					dp[i][curSum] = dp[i][curSum - 1];
				}
			}
		}
		return dp[nums.length][sum / 2] == sum / 2;
	}
}
// 1 2 3