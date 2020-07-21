package com;

public class LongestSubstringWithoutRepeatingCharactersMaxiMumOptimized {
	public int lengthOfLongestSubstring(String s) {
		int left = -1;
		int right = 0;
		int[] freq = new int[256];
		int maxLength = 0;
		for (int i = 0; i < freq.length; ++i) {
			freq[i] = -1;
		}
		while (right < s.length()) {
			if (freq[s.charAt(right)] <= left) {
				maxLength = Math.max(maxLength, right - left);
			} else {
				left = freq[s.charAt(right)];
			}
			freq[s.charAt(right)] = right;
			right++;
		}

		return maxLength;
	}
}
