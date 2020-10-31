package com;

public class JumpGameII {
	public int jump(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int curMaxIndex = 0;
		int[] dp = new int[nums.length];
		dp[0] = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (curMaxIndex < nums[i] + i) {
				for (int j = curMaxIndex + 1; j <= nums[i] + i && j < nums.length; ++j) {
					dp[j] = dp[i] + 1;
				}
				curMaxIndex = nums[i] + i;
			}
		}
		return dp[nums.length - 1];
	}
	
}
