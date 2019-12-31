package com;

/*
 * Function that reverses a string In-place.
 */
public class ReverseStringInPlace {
	public void reverseString(char[] s) {
		if (s.length == 0) {
			return;
		}
		int size = s.length - 1;
		int first = 0;
		int last = size;
		reverse(s, first, last);
	}
//Using recursion
	public void reverse(char[] s, int first, int last) {
		char temp = s[first];
		s[first] = s[last];
		s[last] = temp;
		first = first + 1;
		last = last - 1;
		if (first < last) {
			reverse(s, first, last);
		}
	}
}
