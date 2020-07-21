package com;


public class LongestSubstringWithoutRepeatingCharacters {
	/*
	 * We are using a sliding window to determine lengthOfLongestSubstring
	 */
	public int lengthOfLongestSubstring(String s) {
		int left = 0;
		int right = 0;
		int[] freq = new int[256];
		int maxLength = 0;
		for (int i = 0; i < freq.length; ++i) {
			freq[i] = 0;
		}
		while (right < s.length()) {
			if (freq[s.charAt(right) ] == 0) {
				freq[s.charAt(right) ] = 1;
				maxLength = Math.max(maxLength, right - left + 1);
				right++;
			} else {
				while (s.charAt(left) != s.charAt(right)) {
					freq[s.charAt(left) ] = 0;
					left++;
				}
                freq[s.charAt(left)] = 0;
					left++;
			}
		}
		return maxLength;
	}
}
