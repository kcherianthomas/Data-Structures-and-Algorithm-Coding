package com;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakIteratively {
	public boolean wordBreak(String s, List<String> wordDict) {
        if(s.equals("")) {
        	return false;
        }
		boolean []dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        Set<String> set = new HashSet<>();
        for(String word: wordDict) {
        	set.add(word);
        }
        for(int i=s.length()-1;i>=0;--i) {
            for(int j=s.length();j>i;--j) {
                if(dp[j] && set.contains(s.substring(i, j))) {
                	dp[i] = true;
                	break;
                }
            }
        }
        return dp[0];
    }
}
