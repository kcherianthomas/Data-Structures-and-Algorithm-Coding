package com;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {
	public int numMatchingSubseq(String S, String[] words) {
		Map<String, Boolean> set = new HashMap<>();
		int count = 0;
		for (String word : words) {
			if (word.length() > S.length()) {
				continue;
			}
			if (set.containsKey(word)) {
				if (set.get(word)) {
					count++;
				}
				continue;
			}
			if (checkSubsequence(S, count, word) == 1) {
				count += 1;
				set.put(word, true);
			} else {
				set.put(word, false);
			}
		}
		return count;
	}

	private int checkSubsequence(String S, int count, String word) {
		int sLength = S.length();
		int wLength = word.length();
		int i = 0;
		int j = 0;
		while (i < sLength && j < wLength) {
			if (S.charAt(i) == word.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}
		return (j == wLength) ? 1 : 0;
	}

}
