package com;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int r = matrix.length;
		if (r == 0) {
			return 0;
		}
		int c = matrix[0].length;
		if (c == 0) {
			return 0;
		}
		int out = 0;
		int[][] dp = new int[r][c];
		for (int i = 0; i < r; ++i) {
			dp[i][0] = matrix[i][0] - '0';
			out = Math.max(dp[i][0], out);
		}
		for (int j = 1; j < c; ++j) {
			dp[0][j] = matrix[0][j] - '0';
			out = Math.max(dp[0][j], out);
		}

		for (int i = 1; i < r; ++i) {
			for (int j = 1; j < c; ++j) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
					out = Math.max(dp[i][j], out);
				}
			}
		}
		return out * out;
	}
}
