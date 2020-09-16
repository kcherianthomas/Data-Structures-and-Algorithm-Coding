package com;

public class StringToInteger {
	public int myAtoi(String str) {
		if(str.trim().isEmpty()) {
			return 0;
		}
		int i = 0;
		boolean negative = false;
		while (str.charAt(i) == ' ') {
			i++;
		}
		if (str.charAt(i) == '+') {
			i++;
		} else if (str.charAt(i) == '-') {
			negative = true;
			i++;
		}
		int out = 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			int temp = out * 10 + (str.charAt(i) - '0');
			if (temp / 10 != out) {
				return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			} else {
				out = temp;
			}
			i++;
		}
		return negative ? -out : out;
	}
}
