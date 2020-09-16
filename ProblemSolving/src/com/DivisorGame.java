package com;

import java.util.Arrays;

public class DivisorGame {
	public boolean divisorGame(int N) {
		if (N <= 1) {
			return false;
		}
		boolean[] dp = new boolean[N + 1];
		Arrays.fill(dp, false);
		dp[2] = true;
		for (int i = 3; i <= N; ++i) {
			for (int j = 1; j < i; ++j) {
				if (i % j == 0) {
					if (dp[i - j] == false) {
						dp[i] = true;
					}
					break;
				}
			}
		}
		return dp[N];
		/*
		 * if(N<=1) { return false; } return N%2==0?true:false;
		 */
	}
}
