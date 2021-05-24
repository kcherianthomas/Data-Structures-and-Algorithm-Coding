package com;

import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {
		Stack<Integer> numberStack = new Stack<>();
		Stack<String> insideBracketStack = new Stack<>();
		String curOut = "";
		int val = 0;
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				val = val * 10 + (ch - '0');
			} else if (ch == '[') {
				// add number to number stack and string to string stack
				numberStack.add(val);
				val = 0;
				insideBracketStack.add(curOut);
				curOut = "";
			} else if (ch == ']') {
				// take curout append numberstack.popped time
				// add it to existing insideBracketStack.pop
				int num = numberStack.pop();
				String temp = curOut;
				while (num > 1) {
					curOut += temp;
					num--;
				}
				temp = insideBracketStack.pop();
				curOut = temp + curOut;
			} else {
				curOut += ch;
			}
		}
		return curOut;
	}
}
