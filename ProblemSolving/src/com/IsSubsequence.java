package com;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if (s.length() > t.length()) {
			return false;
		} 
		int i = 0;
		int right = 0;
		while (i < s.length() && right < s.length()) {
			if (s.charAt(i) == t.charAt(right)) {
				i++;
			}
			right++;
		}
		return i == s.length();
	}
}
