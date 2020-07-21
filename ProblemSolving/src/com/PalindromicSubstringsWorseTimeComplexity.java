package com;

public class PalindromicSubstringsWorseTimeComplexity {
	public int countSubstrings(String s) {
		if (s.length() == 0) {
			return 0;
		}
		boolean[][] checkAlreadyCounted = new boolean[s.length() + 1][s.length() + 1];
		countPalindrome(s, 0, 0, checkAlreadyCounted);
		return totalCount;
	}

	private void countPalindrome(String s, int start, int count, boolean[][] checkAlreadyCounted) {

		for (int i = start + 1; i <= s.length(); ++i) {
			if (!checkAlreadyCounted[start][i - 1]) {
				checkAlreadyCounted[start][i - 1] = true;
				if (checkPalindrome(s, start, i - 1)) {
					totalCount += 1;
					countPalindrome(s, i, count, checkAlreadyCounted);

				}
			}
		}
	}

	private boolean checkPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

	int totalCount = 0;

}
