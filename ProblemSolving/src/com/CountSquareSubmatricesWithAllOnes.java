package com;

public class CountSquareSubmatricesWithAllOnes {
	public int countSquares(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		int[][] dp = new int[r][c];
		for (int i = 0; i < r; i++) {
			dp[i][0] = matrix[i][0] == 1 ? 1 : 0;
		}
		for (int j = 1; j < c; j++) {
			dp[0][j] = matrix[0][j] == 1 ? 1 : 0;
		}
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (matrix[i][j] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				count += dp[i][j];
			}
		}
		return count;
	}
}
