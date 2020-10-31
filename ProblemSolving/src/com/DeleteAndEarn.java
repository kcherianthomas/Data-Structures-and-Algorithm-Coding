package com;

public class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		int maxNums = Integer.MIN_VALUE;
		// find max value
		for (int i = 0; i < nums.length; ++i) {
			maxNums = Math.max(maxNums, nums[i]);
		}
		// create an array to store the cumilative values
		// for eg if we have THREE 2's we add 2+2+2 at position index 2
		int[] cumilativeNums = new int[maxNums + 1];
		for (int i = 0; i < nums.length; ++i) {
			cumilativeNums[nums[i]] += nums[i];
		}
		// now we have a dp where dp[i] gives maximum points at that index
		//it can be either max points at index -1 or max points at index-2+cumilativeSum at i
		int[] dp = new int[maxNums + 1];
		dp[0] = 0;
		dp[1] = cumilativeNums[1];
		for (int i = 2; i < dp.length; ++i) {
			dp[i] = Math.max(dp[i - 2] + cumilativeNums[i], dp[i - 1]);
		}
		return dp[maxNums];
	}
}
