package com;

// This method do not work in worse case scenarios
public class PalindromePartitioningIIWorseTimeComplexity {
	public int minCut(String s) {
		int cuts = -1;
		int minCuts = Integer.MAX_VALUE;
		int index = 0;
		return partition(s, index, cuts, minCuts);
	}

	private int partition(String s, int index, int cuts, int minCuts) {
		if (index == s.length()) {
			minCuts = Math.min(minCuts, cuts);
            return minCuts;
		}
		for (int i = index + 1; i <= s.length(); i++) {
			if (checkPalindrome(s, index, i - 1)) {
				minCuts= partition(s, i, cuts+1, minCuts);
			}
		}
		return minCuts;
	}

	private boolean checkPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}
