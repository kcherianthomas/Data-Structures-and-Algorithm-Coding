package com;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		} 
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= s.length(); ++i) {
			int curNumber = s.charAt(i - 1) - '0';
			int preNumber = (s.charAt(i - 2) - '0') * 10 + curNumber;
			if (curNumber >= 1 && curNumber <= 9) {
				dp[i] += dp[i - 1];
			}
			if (preNumber >= 10 && preNumber <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}
}
