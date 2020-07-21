package com;

public class LongestCommonSubsequenceUsingMemoization {
	public int longestCommonSubsequence(String text1, String text2) {
		int length1 = text1.length();
		int length2 = text2.length();
		if (length1 == 0 || length2 == 0) {
			return 0;
		}
		int[][] dp = new int[length1][length2];
		for (int i = 0; i < length1; ++i) {
			for (int j = 0; j < length2; ++j) {
				dp[i][j] = -1;
			}
		}
		return lsd(text1, text2, length1 - 1, length2 - 1, dp);
	}

	private int lsd(String text1, String text2, int i, int j, int[][] dp) {
		if (i < 0 || j < 0) {
			return 0;
		} else if (dp[i][j] != -1) {
			return dp[i][j];
		} else if (text1.charAt(i) == text2.charAt(j)) {
			dp[i][j] = (1 + lsd(text1, text2, i - 1, j - 1, dp));
			return dp[i][j];
		} else {
			dp[i][j] = Math.max(lsd(text1, text2, i - 1, j, dp), lsd(text1, text2, i, j - 1, dp));
			return dp[i][j];
		}
	}
}
