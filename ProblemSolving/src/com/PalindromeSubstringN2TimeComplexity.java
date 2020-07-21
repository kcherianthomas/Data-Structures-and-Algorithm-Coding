package com;

// There is a better algorithm(Manacher's algorithm)that gives the ans in n timecomplexity
public class PalindromeSubstringN2TimeComplexity {
	public int countSubstrings(String s) {
		int caseOne = 0;
		int caseTwo = 0;
		for (int i = 0; i < s.length(); ++i) {
			/*
			 * the case in which one mid element that does not affect palindrome eg: "aba"
			 */
			caseOne += findCount(s, i, i);
			/*
			 * the case in which no mid element eg: "abba"
			 */
			caseTwo += findCount(s, i, i + 1);
		}
		return caseOne + caseTwo;
	}

	private int findCount(String s, int start, int end) {
		int count = 0;
		while (start >= 0 && end < s.length()) {
			if (s.charAt(start--) == s.charAt(end++)) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}
