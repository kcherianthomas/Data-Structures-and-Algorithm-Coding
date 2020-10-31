package com;

public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] A) {
		int len = A.length;
		int[][] dp = new int[len][len];
		// first row
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < len; ++j) {
				dp[i][i] = Integer.MAX_VALUE;
			}
		}
		for (int c = 0; c < len; ++c) {
			dp[0][c] = A[0][c];
		}
		for (int r = 1; r < len; ++r) {
			for (int c = 0; c < len; ++c) {
				dp[r][c] = dp[r - 1][c] + A[r][c];
				if (c - 1 >= 0) {
					dp[r][c] = Math.min(dp[r - 1][c - 1] + A[r][c], dp[r][c]);
				}
				if (c + 1 < len) {
					dp[r][c] = Math.min(dp[r - 1][c + 1] + A[r][c], dp[r][c]);
				}
			}
		}
		int out = Integer.MAX_VALUE;
		for (int c = 0; c < len; ++c) {
			out = Math.min(out, dp[len - 1][c]);
		}
		return out;
	}
}
