package com;

public class MinimumDifficultyOfAJobSchedule {
	public int minDifficulty(int[] jobDifficulty, int d) {
		int noOfJobs = jobDifficulty.length;
		int noOfDays = d;
		if (noOfJobs < noOfDays) {
			return -1;
		}
		// dp[i][j] represents minimum difficulty for completing first j+1 jobs in i+1
		// days
		int[][] dp = new int[noOfDays][noOfJobs];
		dp[0][0] = jobDifficulty[0];
		// max difficulty completing first j+1 jobs in 1 day
		for (int j = 1; j < noOfJobs; ++j) {
			dp[0][j] = Math.max(dp[0][j - 1], jobDifficulty[j]);
		}
		for (int i = 1; i < noOfDays; ++i) {
			for (int j = i; j < noOfJobs; ++j) {
				dp[i][j] = Integer.MAX_VALUE;
				int jobDiff = jobDifficulty[j];
				for (int k = j; k >= i; k--) {
					jobDiff = Math.max(jobDifficulty[k], jobDiff);
					dp[i][j] = Math.min(dp[i][j], jobDiff + dp[i - 1][k - 1]);
				}
			}
		}
		return dp[noOfDays - 1][noOfJobs - 1];
	}
}
