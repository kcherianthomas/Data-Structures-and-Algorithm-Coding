package com;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {

		int[] frequency = new int[26];
		// setting all freq count to zero
		for (int i = 0; i < 26; ++i) {
			frequency[i] = 0;
		}
		// finding frequency of characters in string
		for (int i = 0; i < s.length(); ++i) {
			frequency[s.charAt(i) - 'a']++;
		}
		//to check for characters which are less than k
		int count = 0;
		for (int i = 0; i < 26; ++i) {
			if (frequency[i] < k && frequency[i] > 0) {
				count++;
			}
		}
		if (count == 0) {
			return s.length();
		}
		int j = 0;
		int i = 0;
		int max = 0;
		while (j < s.length()) {
			int freq = frequency[s.charAt(j) - 'a'];
			if (freq < k && freq > 0) {
				if (j - i >= k) {
					max = Math.max(max, longestSubstring(s.substring(i, j), k));
				}
				i = j + 1;
			}
			j++;
		}
		if (j - i >= k) {
			max = Math.max(max, longestSubstring(s.substring(i, j), k));
		}
		return max;

	}
}
