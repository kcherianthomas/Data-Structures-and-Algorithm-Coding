package com;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.length() == 0) {
			return true;
		}
		Set<String> set = new HashSet<>();
		for(String temp: wordDict) {
			set.add(temp);
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i=1;i<dp.length;++i) {
			dp[i] = false;
		}
		
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (dp[j] && set.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
