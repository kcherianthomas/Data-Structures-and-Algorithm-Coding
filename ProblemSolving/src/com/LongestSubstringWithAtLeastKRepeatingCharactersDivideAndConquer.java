package com;

public class LongestSubstringWithAtLeastKRepeatingCharactersDivideAndConquer {
	public int longestSubstring(String s, int k) {
		return longestSubstringUtils(s, k, 0, s.length());

	}

	private int longestSubstringUtils(String s, int k, int start, int end) {
		if (end - start < k) {
			return 0;
		}
		int[] freq = new int[26];
		int longest = 0;
		for (int i = start; i < end; ++i) {
			char ch = s.charAt(i);
			freq[ch - 'a'] += 1;
		}
		for (int i = start; i < end; ++i) {
			char ch = s.charAt(i);
			if (freq[ch - 'a'] != 0 && freq[ch - 'a'] < k) {
				return Math.max(longestSubstringUtils(s, k, start, i), longestSubstringUtils(s, k, i + 1, end));
			}
		}
		longest = end - start;
		return longest;
	}
}
