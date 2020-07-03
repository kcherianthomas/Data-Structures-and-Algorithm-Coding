package com;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public List<String> generateParenthesis(int n) {

		List<String> out = new ArrayList<>();
		if (n <= 0) {
			return out;
		}
		String str = "";
		paranthesis(n, 0, 0, out, str);
		return out;
	}

	private void paranthesis(int n, int open, int close, List<String> out, String str) {
		if (str.length() == n * 2) {
			out.add(str);
		} else {
			if (open < n) {
				paranthesis(n, open + 1, close, out, "(" + str);
			}
			if (close < open) {
				paranthesis(n, open, close + 1, out, str + ")");
			}
		}

	}
}
