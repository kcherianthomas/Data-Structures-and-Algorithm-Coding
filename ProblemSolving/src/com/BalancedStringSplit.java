package com;

import java.util.Stack;

/*
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 */
public class BalancedStringSplit {
	public int balancedStringSplit(String s) {
		int count = 0;
		char top = 'n';
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); ++i) {
			if ((s.charAt(i) == 'L' && stack.isEmpty())) {
				stack.push('L');
				top = 'L';
			} else if ((s.charAt(i) == 'R') && stack.isEmpty()) {
				stack.push('R');
				top = 'R';
			} else if (top == 'L' && s.charAt(i) == 'L' && !stack.isEmpty()) {
				stack.push('L');
			} else if (top == 'R' && s.charAt(i) == 'R' && !stack.isEmpty()) {
				stack.push('R');
			} else if (top == 'L' && s.charAt(i) == 'R' && !stack.isEmpty()) {
				stack.pop();
				if (stack.isEmpty()) {
					top = 'n';
					count++;
				}
			} else if (top == 'R' && s.charAt(i) == 'L' && !stack.isEmpty()) {
				stack.pop();
				if (stack.isEmpty()) {
					top = 'n';
					count++;
				}
			}
		}
		return count;

	}
}
