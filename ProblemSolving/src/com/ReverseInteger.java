package com;

//Given a 32-bit signed integer, reverse digits of an integer.
public class ReverseInteger {
	public int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int digit = x % 10;
			x = x / 10;
			int val = (rev * 10) + digit;
			/*
			 * we find temp = rev*10+digit now if overflow occurred temp/10 will not be
			 * equal to rev and we return 0 else we set rev as temp
			 */
			if (rev != (val / 10)) {
				return 0;
			}
			rev = val;
		}
		return rev;
	}
}
