package com;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {

		List<List<String>> out = new ArrayList<>();
		List<String> stringList = new ArrayList<>();
		partitionPal(0, s, out, stringList);
		return out;
	}

	private void partitionPal(int index, String s, List<List<String>> out, List<String> stringList) {
		if (index == s.length()) {
			out.add(new ArrayList<>(stringList));
			return;
		}
		for (int i = index + 1; i <= s.length(); i++) {
			if (checkPalindrome(s, index, i - 1)) {
				stringList.add(s.substring(index, i));
				partitionPal(i, s, out, stringList);
				stringList.remove(stringList.size() - 1);
			}
		}
	}

	private boolean checkPalindrome(String substring, int start, int end) {
		while (start < end) {
			if (substring.charAt(start++) != substring.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}
