package com;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int r = obstacleGrid.length;
		if (r == 0) {
			return 0;
		}
		int c = obstacleGrid[0].length;
		if (c == 0) {
			return 0;
		}
		int[][] dp = new int[r][c];

		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = -1;
				}
			}
		}
		dp[0][0] = dp[0][0] == -1 ? 0 : 1;
		for (int i = 1; i < r; ++i) {
			dp[i][0] = dp[i][0] == -1 ? 0 : dp[i - 1][0];
		}
		for (int j = 1; j < c; ++j) {
			dp[0][j] = dp[0][j] == -1 ? 0 : dp[0][j - 1];
		}

		for (int i = 1; i < r; ++i) {
			for (int j = 1; j < c; ++j) {
				dp[i][j] = dp[i][j] == -1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[r - 1][c - 1];
	}
}
