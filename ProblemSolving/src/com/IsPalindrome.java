package com;

public class IsPalindrome {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (!Character.isAlphabetic(s.charAt(start))) {
				start++;
			}
			while (!Character.isAlphabetic(s.charAt(end))) {
				end--;
			}
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
			
		}
		return true;
	}
}
