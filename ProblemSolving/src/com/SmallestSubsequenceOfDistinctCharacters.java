package com;

import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {
	public String smallestSubsequence(String s) {
		String out = "";
		int[] lastSeenIndex = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			lastSeenIndex[ch - 'a'] = i;
		}
		boolean[] used = new boolean[26];
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (used[ch - 'a']) {
				continue;
			}
			while (!stack.isEmpty() && ch < stack.peek() && lastSeenIndex[stack.peek() - 'a'] > i) {
				used[stack.pop() - 'a'] = false;
			}
			stack.add(ch);
			used[ch - 'a'] = true;
		}
		while (!stack.isEmpty()) {
			out = stack.pop() + out;
		}
		return out;
	}
}
