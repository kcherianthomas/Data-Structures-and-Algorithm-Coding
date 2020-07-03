package com;

public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {

		if (s1.length() > s2.length()) {
			return false;
		}
		int[] s1Count = new int[26];
		int[] s2Count = new int[26];
		for (int i = 0; i < 26; ++i) {
			s1Count[i] = 0;
			s2Count[i] = 0;
		}
		for (int i = 0; i < s1.length(); ++i) {
			s1Count[s1.charAt(i) - 'a'] += 1;
			s2Count[s2.charAt(i) - 'a'] += 1;
		}
		for (int i = 0; i < s2.length() - s1.length(); ++i) {
			boolean isPermu = match(s1Count, s2Count);
			if (isPermu) {
				return true;
			}
			s2Count[s2.charAt(i) - 'a'] -= 1;
			s2Count[s2.charAt(i + s1.length()) - 'a'] += 1;
		}
		return match(s1Count, s2Count);
	}

	private boolean match(int[] s1Count, int[] s2Count) {
		for (int i = 0; i < 26; ++i) {
			if (s1Count[i] != s2Count[i]) {
				return false;
			}
		}
		return true;
	}
}
