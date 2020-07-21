package com;

public class LongestPalindromicSubstring {
	String max = "";

	public String longestPalindrome(String s) {

		for (int i = 0; i < s.length(); ++i) {
			/*
			 * the case in which one mid element that does not affect palindrome eg: "aba"
			 */
			findLength(s, i, i);
			/*
			 * the case in which no mid element eg: "abba"
			 */
			findLength(s, i, i + 1);
		}
		return max;

	}

	private void findLength(String s, int start, int end) {
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		if (s.substring(start + 1, end).length() - 1 > max.length() - 1) {
			max = s.substring(start + 1, end);
		}
	}
}
