package com;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.add(i);
			} else if (ch == ')') {
				if (stack.isEmpty()) {
					set.add(i);
				} else {
					stack.pop();
				}
			}
		}
		while (!stack.isEmpty()) {
			set.add(stack.pop());
		}
		StringBuilder bld = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			if (!set.contains(i)) {
				bld.append(s.charAt(i));
			}
		}
		return bld.toString();
	}
}
